package sunbeam;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieGenre;
	public Movie() {
	}
	public Movie(int movieId, String movieName, String movieGenre) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	@Override
	public String toString() {
		return "Movie [ Name = " + movieName + ", Genre = " + movieGenre + "]";
	}
	
}
