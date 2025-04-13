package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String mert;
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);


        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("🔁 Tekrar eden çalışanlar:");
        for (Employee e : duplicates) {
            if (e != null) {
                System.out.println(e);
            }
        }


        Map<Integer, Employee> uniqueEmployees = findUniques(employees);
        System.out.println("\n✅ Tekrar etmeyen ve bir kez tekrar eden çalışanlar:");
        for (Map.Entry<Integer, Employee> entry : uniqueEmployees.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println("ID: " + entry.getKey() + ", Çalışan: " + entry.getValue());
            }
        }


        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," +
                " due to İsmet Pasha's organization of an irregular militia into a regular army. " +
                "The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." +
                " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." +
                " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" +
                "June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." +
                "Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." +
                "The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." +
                "For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." +
                "Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." +
                "French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        Map<String, Integer> wordCount = WordCounter.calculatedWord(text);


        System.out.println("\n🔤 Kelime sayıları:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Integer> seenIds = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();
        if (list == null) return duplicates;
        for (Employee e : list) {
            if (e != null && !seenIds.add(e.getId())) {
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Set<Integer> seenIds = new HashSet<>();
        Set<Integer> duplicatesIds = new HashSet<>();
        Map<Integer, Employee> uniqueEmployees = new HashMap<>();

        if (list == null) return uniqueEmployees;

        for (Employee e : list) {
            if (e != null) {
                int id = e.getId();
                if (!seenIds.add(id)) {
                    duplicatesIds.add(id);
                }
            }
        }

        for (Employee e : list) {
            if (e != null && !duplicatesIds.contains(e.getId())) {
                uniqueEmployees.put(e.getId(), e);
            }
        }

        return uniqueEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> nonDuplicates = new ArrayList<>();
        if (list == null) return nonDuplicates;

        for (Employee e : list) {
            if (e != null) {
                countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
            }
        }

        for (Employee e : list) {
            if (e != null && countMap.get(e.getId()) == 1) {
                nonDuplicates.add(e);
            }
        }

        return nonDuplicates;
    }
}
