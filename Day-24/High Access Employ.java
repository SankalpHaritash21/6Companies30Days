class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n = access_times.size();
        Map<String, List<Integer>> map = new HashMap<>();
        for(List<String> access_time : access_times){
            String employee = access_time.get(0);
            int time = Integer.valueOf(access_time.get(1));
            map.computeIfAbsent(employee, v->new ArrayList<>()).add(time);
        }
        List<String> defaulter = new ArrayList<>();
        for(String employee : map.keySet()){
            List<Integer> times = map.get(employee);
            if(times.size() <= 2)
                continue;
            Collections.sort(times);
            int len = times.size();
            for(int i=0; i<len-2; i++){
                if(times.get(i)+ 100 > times.get(i+1) && times.get(i)+ 100 > times.get(i+2)){
                    defaulter.add(employee);
                    break;
                }
            }
        }
        return defaulter;
    }
}