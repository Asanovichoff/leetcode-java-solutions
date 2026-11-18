class Solution {

    //1. go through logs to find letter log
    // 2. put it into treeset, that will manage correct order
    //3. go trough treeset and put the into result;
    //4. go through logs and put digit logs into result
    private int compareLogs(String a, String b) {// lambda function to compare logs
        String[] first = a.split(" ", 2);
        String[] second = b.split(" ", 2);

        int comparison = first[1].compareTo(second[1]);
        if (comparison == 0) {
            return first[0].compareTo(second[0]);
        }
        return comparison;
    }
    public String[] reorderLogFiles(String[] logs) {
        TreeSet<String> letterSet = new TreeSet<>(this::compareLogs);
        String[] result = new String[logs.length];
        int idx = 0;
        for (String log : logs) { // putting letter-logs in. sorted order
            char lastLetter = log.charAt(log.length()-1);
            if (!Character.isDigit(lastLetter)) {
                letterSet.add(log);
            }
        }
        for (String key : letterSet) { // putting sorted letter-logs into result;
            result[idx] = key;
            idx++;
        }
        for (String log : logs) { // putting digit - logs in retative order
            char lastLetter = log.charAt(log.length()-1);
            if (Character.isDigit(lastLetter)) {
                result[idx] = log;
                idx++;
            }
        }

        return result;

    }
}