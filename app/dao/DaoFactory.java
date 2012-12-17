package dao;

public class DaoFactory
{
	private static DaoFactory df = null;

	private UserDao user;
	private BallotDao ballot;
	private CriteriaDao criteria;
	private ProjectDao project;

	private DaoFactory()
	{
		this.criteria = new CriteriaDao();
		this.project = new ProjectDao();
		this.user = new UserDao();
		this.ballot = new BallotDao();
	}

	public static DaoFactory getInstance()
	{
		if (df == null) 
		{
			df = new DaoFactory();
		}

		return df;
	}

	public UserDao getDao()
	{
		return this.user;
	}

	public BallotDao getBallot()
	{
		return this.ballot;
	}

	public CriteriaDao getCriteria()
	{
		return this.criteria;
	}

	public ProjectDao getProject()
	{
		return this.project;
	}

}