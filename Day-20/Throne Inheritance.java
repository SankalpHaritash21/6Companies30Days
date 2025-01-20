class ThroneInheritance {
    String kingName;
    Map<String, List<String>> map = new HashMap<>();  // for cache children;
    Map<String, Boolean> alive = new HashMap<>();
    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
    }
    
    public void birth(String pn, String cn) {
        map.computeIfAbsent(pn, k -> new ArrayList<>());
        map.get(pn).add(cn);
    }
    
    public void death(String name) {
        alive.put(name, false);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> list = getList(kingName);  //all list with alive and died
        List<String> res = new ArrayList<>();
        for (String s : list)
            if (alive.getOrDefault(s, true)) res.add(s);  // remove died
        return res;
    }
    
    private List<String> getList(String p) {   // recursion to get children and build the inheritance list;
        List<String> res = new ArrayList<>();
        res.add(p);
        List<String> cs = map.getOrDefault(p, new ArrayList<>());
        for (String c : cs) {
            List<String> tmp = getList(c);
            for (String cc : tmp) res.add(cc);
        }
        return res;
    }
}