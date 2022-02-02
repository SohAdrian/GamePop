import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/gamespop";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_REVIEWS_SQL = "INSERT INTO GAME_REVIEW"
			+ " (reviewId, gameName, username, rating, comment) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_REVIEW_BY_ID = "select reviewId, gameName, username, rating, comment from GAME_REVIEW where reviewId =?";
	private static final String SELECT_ALL_REVIEWS = "select * from GAME_REVIEW ";
	private static final String DELETE_REVIEWS_SQL = "delete from GAME_REVIEW where reviewId = ?;";
	private static final String UPDATE_REVIEWS_SQL = "update GAME_REVIEW set username = ?, rating = ?, comment = ? where reviewId = ?;";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
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
			case "/ReviewServlet/delete":
				// deleteReview(request, response);
				break;
			case "/ReviewServlet/edit":
				// showEditForm(request, response);
				break;
			case "/ReviewServlet/update":
				// updateReview(request, response);
				break;
			case "/ReviewServlet/GameReview":
				listReviews(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listReviews(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Review> reviews = new ArrayList<>();
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REVIEWS);) {

			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				Number reviewId = rs.getInt("reviewId");
				String gameName = rs.getString("gameName");
				String username = rs.getString("username");
				Number rating = rs.getInt("rating");
				String comment = rs.getString("comment");
				reviews.add(new Review(reviewId, gameName, username, rating, comment));
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		// Step 5.4: Set the games list into the listGames attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listGames", reviews);
		request.getRequestDispatcher("/GameReview.jsp").forward(request, response);

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

		response.setContentType("text/html");

		// Step 1: Initialize a PrintWriter object to return the html values via the
		// response

		PrintWriter out = response.getWriter();

		// Step 2: retrieve the parameters from the request from the web form

		HttpSession session = request.getSession();

		String n = (String) session.getAttribute("gameName");

		// String n = request.getParameter("gameName");

		String id = request.getParameter("reviewId");
		String u = request.getParameter("username");
		String r = request.getParameter("rating");
		String c = request.getParameter("comment");

		// Step 3: attempt connection to database using JDBC

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamespop", "root", "");

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into GAME_REVIEW values(?,?,?,?,?)");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setString(1, id);
			ps.setString(2, n);
			ps.setString(3, u);
			ps.setString(4, r);
			ps.setString(5, c);

			// Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();

			// Step 7: check if the query had been successfully execute, return �You are
			// successfully registered� via the response,
//			if (i > 0) {
//				PrintWriter writer = response.getWriter();
//				writer.println("<h1>" + "You have successfully registered an account!" + "</h1>");
//				writer.close();
//			}
		}

		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
	}

}
