import java.util.ArrayList;
import java.util.Arrays;

public class CFUserBasedRecommender {
	private double[][] ratingsMatrix;
	private double[][] normalizedRatingsMatrix;
	private int rowSize;
	private int colSize;
	private ArrayList<String> usersList;
	private ArrayList<String> moviesList;

	public CFUserBasedRecommender(double[][] ratingsMatrix,
			int rowSize, int colSize) {
		this.ratingsMatrix = ratingsMatrix;
		this.rowSize = rowSize;
		this.colSize = colSize;
	}

	public void getUserbasedRecommendations(String userName,int numberOfNeighbours) {

		normalizedRatingsMatrix = getNormalizedRatingsMatrix();
		double[][] pearsonCoeffs = populatePearsonCoefficients(normalizedRatingsMatrix);
		int user = usersList.indexOf(userName);
		int[] neighbours = findNearestNeighbours(pearsonCoeffs[user],0, numberOfNeighbours);
		System.out.println("Nearest neighbours for "+userName);
		for(int i=0;i<neighbours.length;i++){
			System.out.print(usersList.get(neighbours[i])+"\t");
		}
		System.out.println();
		double[] predictedRatings = predictRatingsForUser(user, neighbours,pearsonCoeffs);
		System.out.println("Recommendations for " + userName);
		for (int i = 0; i < colSize; i++) {
			if (predictedRatings[i] > 0) {
				System.out.println(moviesList.get(i));
			}
		}
	}
// predicts the rating for a particular user using nearest neighbours ratings. 
	public double[] predictRatingsForUser(int user, int[] neighbours,double[][] pearsonCoeffs) {
		double[] predictedRatings = new double[colSize];
		for (int i = 0; i < colSize; i++) {
			if (ratingsMatrix[user][i] == -1){ 
				double weightedRatings = 0;
				double similaritySum = 0;
				for(int j=0;j<neighbours.length;j++){
					if(ratingsMatrix[neighbours[j]][i] != -1){  // We have used weighted ratings for predicting the rating for user 
						//weighted rating = Sum of (similarity * neighbour rating) / sum of similarities
						weightedRatings = weightedRatings + pearsonCoeffs[user][neighbours[j]] * ratingsMatrix[neighbours[j]][i];
						similaritySum = similaritySum + pearsonCoeffs[user][neighbours[j]];
					}
					predictedRatings[i] = weightedRatings/similaritySum;
			}
			}
		}
		return predictedRatings;
	}
// finds the nearest neighbours to given user
	public int[] findNearestNeighbours(double[] pearsonCoeffs,int user, int numberOfNeighbours) {
		double[] sortedPearsonCoeffs = Arrays.copyOf(pearsonCoeffs, rowSize);
		int[] neighbours = new int[numberOfNeighbours];
		
		Arrays.sort(sortedPearsonCoeffs);
		sortedPearsonCoeffs = Arrays.copyOfRange(sortedPearsonCoeffs, rowSize-numberOfNeighbours, rowSize);
		int k=0;
		for(int i=0;i<sortedPearsonCoeffs.length;i++){
			for(int j=0;j<pearsonCoeffs.length;j++){
				if(sortedPearsonCoeffs[i] == pearsonCoeffs[j]){
					neighbours[k++]=j;
				}
			}
		}
		
		return neighbours;
	}
// computer normalized ratings matrix by subtracting the mean of row value from each row.
	public double[][] getNormalizedRatingsMatrix() {
		double[][] normalizedRatingsMatrix = new double[rowSize][colSize];

		double[][] rowMeans = new double[rowSize][1];
		for (int i = 0; i < rowSize; i++) {
			double sum = 0;
			double numberofRatings = 0;
			for (int j = 0; j < colSize; j++) {
				if (ratingsMatrix[i][j] != -1) {
					sum = sum + ratingsMatrix[i][j];
					numberofRatings++;
				}
			}
			rowMeans[i][0] = sum / numberofRatings;
		}

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (ratingsMatrix[i][j] == -1)
					normalizedRatingsMatrix[i][j] = 0;
				else {
					normalizedRatingsMatrix[i][j] = ratingsMatrix[i][j] - rowMeans[i][0];
				}
			}
		}
		return normalizedRatingsMatrix;
	}
// calculate pearson coefficients for two users
	public double calculatePearsonCoefficient(int user1, int user2) {
		double sumXY = 0, sumX2 = 0, sumY2 = 0;
		for (int i = 0; i < colSize; i++) {
			sumXY = sumXY + normalizedRatingsMatrix[user1][i] * normalizedRatingsMatrix[user2][i];
			sumX2 = sumX2 + Math.pow(normalizedRatingsMatrix[user1][i], 2);
			sumY2 = sumY2 + Math.pow(normalizedRatingsMatrix[user2][i], 2);
		}

		return (sumXY / (Math.sqrt(sumX2) * Math.sqrt(sumY2)));
	}
//populates pearson coefficients for all users
	public double[][] populatePearsonCoefficients(double[][] ratingsMatrix) {
		double[][] pearsonCoeffs = new double[rowSize][rowSize];
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < rowSize; j++) {
				if (i == j)
					pearsonCoeffs[i][j] = Double.NEGATIVE_INFINITY;
				else
					pearsonCoeffs[i][j] = calculatePearsonCoefficient( i, j);
			}
		}
		return pearsonCoeffs;
	}

	public void setMovies(ArrayList<String> moviesList) {
		this.moviesList = moviesList;
	}

	public void setUsers(ArrayList<String> usersList) {
		this.usersList = usersList;
	}

}
