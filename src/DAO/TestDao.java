package DAO;

public class TestDao {

	public static void main(String[] args) {
		DAOOrderToBill dao=new DAOOrderToBillOracle();
		dao.updateCustomerServices(1, "ACTIVE");

	}

}
