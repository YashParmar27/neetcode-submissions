class TimeMap {
    Map<String, TreeMap<Integer,String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        TreeMap<Integer, String> timestamps = timeMap.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();
    }
}
