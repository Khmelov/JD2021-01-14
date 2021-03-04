package by.it;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HomeWorkChecker {


    public static void main(String[] args) {
        HomeWorkChecker tester = new HomeWorkChecker();
        tester.all();
    }

    private PrintStream getNull() {
        return new PrintStream(new OutputStream() {
            public void write(int b) {
                //просто глушим все
            }
        });
    }

    public void all() {
        //прогон всех тестов во всех пакетах
        PrintStream out = System.out;
        System.setErr(getNull());
        System.setOut(getNull());
        Package root = this.getClass().getPackage();
        Set<Class<?>> classes = HomeWorkChecker.getTestClasses(root.getName());
        Map<String, Integer> mapCount = new TreeMap<>();
        for (Class<?> c : classes) {
            //if (!c.toString().contains("are") && !c.toString().contains("evstr")) continue;
            int count = 0;
            out.print(".");
            try {
                Map<Method, Boolean> res = check(c);
                for (Map.Entry<Method, Boolean> m : res.entrySet()) {
                    if (m.getValue()) count++;
                }
                mapCount.put(c.toString(), count);

                //if (90 >= mapCount.size()) break;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        out.println();
        System.setOut(out);
        Map<String, Integer[]> result = buildEstimates(mapCount);
        printEstimates(result);
    }

    private Map<String, Integer[]> buildEstimates(Map<String, Integer> mapCount) {
        Map<String, Integer[]> result = new TreeMap<>();
        for (Map.Entry<String, Integer> r : mapCount.entrySet()) {
            String line = r.getKey() + "=" + r.getValue();
            Matcher m = Pattern.compile("by.it.([a-zA-Z_]+).+jd01_([0-9]{2})=([0-9]+)").matcher(line);
            if (m.find()) {
                String user = m.group(1);
                if (!result.containsKey(user)) {
                    Integer[] estimates = new Integer[21];
                    Arrays.fill(estimates, 0);
                    result.put(user, estimates);
                }
                int col = Integer.parseInt(m.group(2)) - 1;
                int value = Integer.parseInt(m.group(3));
                result.get(user)[col] = value;
            }
        }
        return result;
    }

    private void printEstimates(Map<String, Integer[]> result) {
        try (PrintWriter out = new PrintWriter("estimates.txt")) {
            double[] A = {
                    3, 4, 3, 3, 3, 2, 3, 5, 2, 2, 1, 3, 1, 1, 1,
                    1, 1, 1, 1, 1, 1
            };
            double[] B = {
                    6, 8, 6, 5, 5, 4, 6, 10, 4, 4, 2, 6, 2, 2, 2,
                    2, 2, 2, 2, 2, 2
            };
            double[] C = {
                    9, 12, 8, 7, 7, 6, 9, 14, 6, 5, 3, 9, 3, 3, 3,
                    3, 3, 3, 3, 3, 3
            };

            for (Map.Entry<String, Integer[]> line : result.entrySet()) {
                System.out.printf("\n%20s  ", line.getKey());
                out.printf("\n%20s  ", line.getKey());
                Integer[] estimates = line.getValue();
                for (int i = 0, estimatesLength = estimates.length; i < estimatesLength; i++) {
                    double count = estimates[i];
                    double d = 0;
                    if (count > 0 && count <= A[i]) d = 4 + 2 * count / A[i];
                    if (count > A[i] && count <= B[i]) d = 4 + 4 * count / B[i];
                    if (count > B[i] && count <= C[i]) d = 4 + 6 * count / C[i];
                    long estimate = Math.round(d);
                    String e = d > 0 ? estimate < 10 ? Long.toString(estimate) : "■" : ".";
                    System.out.printf(" %1s", e);
                    out.printf(" %1s", e);
                    if (i % 5 == 4) {
                        System.out.print("   ");
                        out.print("   ");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Method, Boolean> check(Class<?> cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map<Method, Boolean> result = new TreeMap<>(Comparator.comparing(Method::toString));
        Object test = cls.getConstructor().newInstance();
        try {
            cls.getField("showSystemOut").set(null, false); //если есть возможность отключаем вывод
        } catch (NoSuchFieldException e) {
            //e.printStackTrace(); - нет смысла он отключен
        }
        List<Method> methods = Arrays.stream(cls.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(Test.class))
                .collect(Collectors.toList());
        for (Method method : methods) {
            try {
                method.invoke(test);
                setResult(result, method, true, null);
            } catch (Exception e) {
                setResult(result, method, false, e);
            }
        }
        return result;
    }

    private void setResult(Map<Method, Boolean> result, Method method, boolean b, Exception e) {
        boolean invert = method.toString().contains("Test_jd01_13.testTaskC()");
        if (invert) {
            invert = e == null || !(e.getCause() instanceof AssertionError);
        }
        result.put(method, b ^ invert);
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The TreeSet for classes. Filter: name started as "Test..." and not contains $xxx in name
     */
    private static Set<Class<?>> getTestClasses(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        TreeSet<Class<?>> result = new TreeSet<>(Comparator.comparing(Class::toString));
        for (Class<?> aClass : classes) {
            String simpleName = aClass.getSimpleName();
            if (simpleName.startsWith("Test") && !simpleName.contains("$")) {
                result.add(aClass);
            }
        }
        return result;
    }


    /**
     * Recursive method used to find all classes in a given directory and sub-dirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     */
    private static List<Class<?>> findClasses(File directory, String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                try {
                    classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return classes;

    }
}
