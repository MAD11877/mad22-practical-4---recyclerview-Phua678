package sg.edu.np.mad.practical_mad_phuachengann;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(String Name,String Desc,int ID, boolean Followed){
        this.name = Name ;
        this.description = Desc;
        this.id = ID;
        this.followed = Followed;
    }
}