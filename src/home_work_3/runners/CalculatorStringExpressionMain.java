package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorStringExpression;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

/* 	14.8 ������� ����� CalculatorStringExpressionMain � ������� ����� ����� ����� (main �����). � main ������ ���������
������� ��������� ������������ CalculatorStringExpression � ��������� ������ �� ������� ���������� ��������� ���������
�� ������� 1. ������� � ������� ���������.
*/

public class CalculatorStringExpressionMain {

	public static void main(String[] args) {

		CalculatorStringExpression calc = new CalculatorStringExpression(new CalculatorWithMathCopy());

		System.out.println("2+2*2 = " + calc.returnValue("2+2*2"));
		System.out.println("-2+2*2 = " + calc.returnValue("-2+2*2"));
		System.out.println("2-2*2 = " + calc.returnValue("2-2*2"));
		System.out.println("-2+2^3 = " + calc.returnValue("-2+2^3"));
		System.out.println("(-2+1)^3 = " + calc.returnValue("(-2+1)^3"));
		System.out.println("-(-2+1)^3 = " + calc.returnValue("-(-2+1)^3"));
		System.out.println("PI = " + calc.returnValue("PI"));
		System.out.println("E = " + calc.returnValue("E"));
		System.out.println("-E = " + calc.returnValue("-E"));
		System.out.println("(-2 + PI^-3 * -E)^3 = " + calc.returnValue("(-2 + PI^-3 * -E)^3"));
		System.out.println("|(-2 + PI^-3 * -E)|^3 = " + calc.returnValue("|(-2 + PI^-3 * -E)|^3"));
	}
}