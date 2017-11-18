public class Human{

    private String name;
    public Human(String name){
        this.setName(name);
    }
    public void introduce(){
        System.out.println("姓名:"+getName());
    }

    public String getName() {

        return name;
    }

    public void setName(String n) {

        name=n;
    }
}
