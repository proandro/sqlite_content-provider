package todolist.youtube.com.codetutor.bean;



public class ToDo {

    private long id;
    private String toDo;
    private String place;
    private String petname;

    public ToDo(){
        super();
    }

    public ToDo(long id, String toDo){
        this.id=id;
        this.toDo=toDo;
    }

    public ToDo(String toDo, String place,String petname){
        this.toDo=toDo;
        this.place=place;
        this.petname=petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetname() {
        return petname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
