package ui;

import ui.pojo.Location;
import ui.pojo.RequestPostGoogleMaps;

import java.util.ArrayList;
import java.util.List;

public class GooglePageObject {

    public RequestPostGoogleMaps addPlacePayload() {

        RequestPostGoogleMaps addPlace = new RequestPostGoogleMaps();

        addPlace.setAccuracy(50);
        addPlace.setName("ceva nume nou");
        addPlace.setPhone_number("92 343 534 5342");
        addPlace.setAddress("adresa cea noua");
        addPlace.setLanguage("FRA");
        addPlace.setWebsite("http://google.com");
        List<String> myList = new ArrayList<>();
        myList.add("CEVA");
        myList.add("ceva");
        addPlace.setTypes(myList);
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);

        return addPlace;
    }
}
