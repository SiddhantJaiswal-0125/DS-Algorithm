public  class test1 {
    public enum Media{
        Book,cd,music;
    }

    public static void main(String[] args) {
        for(Media m : Media.values())
            System.out.println(m);
    }
}