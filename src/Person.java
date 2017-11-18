public class Person {
    private String name;
    private int age;
    private int eyes;
    public Person(String name,int age,int eyes){
        System.out.println("父类中的构造");
        this.setName(name);
        this.setAge(age);
        this.setEyes(eyes);
    }
    public void introduce(){
        System.out.println("姓名:"+getName()+",年龄:"+getAge()+"，眼睛："+getEyes());
    }

    public String getName() {

        return name;
    }

    public void setName(String n) {

        name=n;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int a) {
        if (a>=0&&a<150){
            age=a;
        }
    }
    public void setEyes(int e){
        eyes=e;
    }

    public int getEyes() {
        return eyes;
    }
}
