import java.util.Scanner;

public class DepositCalculator {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.calculateDepositOutput();
    }

    public void calculateDepositOutput() {
        int depositType;
        int depositAmount;
        int depositPeriod;

        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        double depositResult = 0;
        if (depositType == 1) {
            depositResult = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            depositResult = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod
                + " лет превратятся в " + depositResult);
    }

    public double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double compoundedInterest = depositAmount * Math.pow(1 + yearRate / 12, 12 * depositPeriod);
        return roundToDecimalPlaces(compoundedInterest, 2);
    }

    public double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return roundToDecimalPlaces(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    public double roundToDecimalPlaces(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
