

public class Contact {
    private  String name;
    private  String phoneNumber;
    private  String nameNumber = name +" | "+ phoneNumber;;

    Contact(){}

    Contact(String name,String num){
        this.name =name;
        this.phoneNumber=num;
        this.nameNumber=name+" | "+num;
    }

    public String getName() {
        return this.name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  String getPhoneNumber() {
        return phoneNumber;
    }

    public  void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  String getNameNumber() {
        return nameNumber;
    }

    public  void setNameNumber(String nameNumber) {
        this.nameNumber = nameNumber;
    }
}
