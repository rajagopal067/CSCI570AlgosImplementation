import java.util.ArrayList;

public class TestCFUserBasedRecommender {

	public static void main(String[] args) {
		double[][] ratingsMatrix = { 
				{ 3, 4, -1, 5, 1, -1, 4 },
				{ 5, 5, 4, -1, -1, -1, -1 }, 
				{ -1, -1, -1, 1, 4, 5, -1 },
				{ -1, 3, -1, -1, -1, 5, 4 } 
				};

		ArrayList<String> users = new ArrayList<String>();
		users.add("A");
		users.add("B");
		users.add("C");
		users.add("D");

		ArrayList<String> movies = new ArrayList<String>();
		movies.add("M1");
		movies.add("M2");
		movies.add("M3");
		movies.add("M4");
		movies.add("M5");
		movies.add("M6");
		movies.add("M6");

		CFUserBasedRecommender recommender  = new CFUserBasedRecommender(ratingsMatrix, 4, 7);
		recommender.setMovies(movies);
		recommender.setUsers(users);
		
		// Parameter1 : UserName for which we need recommendations
		// Parameter2 : Number of nearest neighbours to be considered while computing recommendations
		recommender.getUserbasedRecommendations("A",2);

		
		
		
	}

}
