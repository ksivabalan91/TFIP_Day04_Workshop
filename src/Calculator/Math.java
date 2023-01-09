package Calculator;

public class Math {

    public String calculate(String problem){
        String[] initial = problem.trim().split(" ",-1);
        Float result = 0f;
        Float operand_1 = Float.parseFloat(initial[0]);
        Float operand_2 = Float.parseFloat(initial[2]);
        String operator = initial[1];

        switch(operator){
            case "+": 
            result = operand_1+operand_2;
            break;
            case "-": 
            result = operand_1-operand_2;
            break;

            case "*": 
            result = operand_1*operand_2;
            break;

            case "/": 
            result = operand_1/operand_2;
            break;          

        }

        String ans = result.toString();                     

        return ans;

    }    
}
