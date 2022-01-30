import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/gamespop";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	// Step 2: Prepare list of SQL prepared statements to perform Retrieve to our
	// database
	private static final String SELECT_GAME_BY_ID = "select gameName, gamePicture, gameDescription, genre from GameDetails where gameName =?";
	private static final String SELECT_ALL_GAMES = "select * from GameDetails";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
	protected Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/GameServlet/dashboard":
				listGames(request, response);
				break;
			}
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	// Step 5: listUsers function to connect to the database and retrieve all users
		// records
		private void listGames(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			List<Game> games = new ArrayList<>();
			try (Connection connection = getConnection();

					// Step 5.1: Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GAMES);) {

				// Step 5.2: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 5.3: Process the ResultSet object.
				while (rs.next()) {
					String gameName = rs.getString("gameName");
					String gamePicture = rs.getString("gamePicture");
					String gameDescription = rs.getString("gameDescription");
					String genre = rs.getString("genre");
					games.add(new Game(gameName, gamePicture, gameDescription, genre));
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			// Step 5.4: Set the users list into the listUsers attribute to be pass to the
			// userManagement.jsp
			request.setAttribute("listGames", games);
			request.getRequestDispatcher("/gameReview.jsp").forward(request, response);

		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
