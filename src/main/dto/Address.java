package main.dto;

public class Address implements iAddress {
	private String gade = "";
	private String nr = "";
	private String by = "";
	private String postNr = "";
	private String land = "";

	@Override
	public void setGade(String gade) {
		this.gade = gade;
	}

	@Override
	public String getGade() {
		return gade;
	}

	@Override
	public void setNr(String nr) {
		this.nr = nr;
	}

	@Override
	public String getNr() {
		return nr;
	}

	@Override
	public void setBy(String by) {
		this.by = by;
	}

	@Override
	public String getBy() {
		return by;
	}

	@Override
	public void setLand(String land) {
		this.land = land;
	}

	@Override
	public String getLand() {
		return land;
	}

	@Override
	public void setPostNr(String postNr) {
		this.postNr = postNr;
	}

	@Override
	public String getPostNr() {
		return postNr;
	}

	@Override
	public String toString(){
		return gade + " " + nr + " " + by + " " + postNr + " " + land;
	}
}
