package com.Movie.model;

public class Theatre {
	
	private int theatreId;
    private String name;
    private String location;
    private int totalRows;
    private int seatsPerRow;

    public Theatre(int theatreId, String name, String location, int totalRows, int seatsPerRow) {
        this.theatreId = theatreId;
        this.name = name;
        this.location = location;
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
    }

    public int getTheatreId() { return theatreId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getTotalRows() { return totalRows; }
    public int getSeatsPerRow() { return seatsPerRow; }

}
