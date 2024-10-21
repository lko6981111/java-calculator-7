package calculator;

public class StringCalculator {

    public int add(String input) {

        //2. 문자열 구분
        // 빈 문자열 또는 null 입력 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 (쉼표와 콜론)
        String numbers = input;

        // 커스텀 구분자가 있는 경우 처리
        if (input.startsWith("//")) {
            String[] result = extractCustomDelimiter(input);
            delimiter = result[0];
            numbers = result[1];
        }

        // 구분자를 기준으로 숫자를 분리
        String[] tokens = numbers.split(delimiter);

        return 0;

    }

    // 커스텀 구분자를 추출하는 static 메서드
    private static String[] extractCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\n");
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String delimiter = input.substring(2, delimiterIndex); // 커스텀 구분자 추출
        String numbers = input.substring(delimiterIndex + 1);  // 숫자 부분

        return new String[]{delimiter, numbers};  // 구분자와 숫자 부분을 배열로 반환
    }


}
