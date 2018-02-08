import java.util.ArrayList;

/**
 * Created by TCC on 2/6/2018.
 */

public class City {


    private String name;
    ArrayList cinemas = new ArrayList();

    public City () {}

    public City(String name, ArrayList cinemas) {
        this.name = name;
        this.cinemas = cinemas;
    }


    public String getName(){
        return name;
    }

    public ArrayList getCinemas(){return cinemas;}
}
