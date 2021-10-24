package ACaesar;

public class Caesar {
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я'};
    char exception = ',';
    //    гыpoцbzтчzb
    String text = "dimahv,ost,ov";
    int k = 5;
    int a = 14;
    int n = alphabet.length;
    int x;
    char c;
    char y;
    StringBuilder new_str = new StringBuilder();

    void encode(String text, int k, int a) {
        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == exception) {
                y = c;
                new_str.append(y);
            }
            for (int j = 0; j < n; j++) {
                if (alphabet[j] == c) {
                    x = j;
                    y = alphabet[(k * x + a) % n];
                    new_str.append(y);
                }
            }
        }
        System.out.println(new_str);
    }

    int calcInverse(int k, int n) {
        for (int i = 1; i < n; i++) {
            if ((k * i) % n == 1)
                return i;
        }
        return 1;
    }

    void decode(int k, int n, int a) {
        int kInverse = calcInverse(k, n);
        String text = "гыpoцbzтчzb";
        StringBuilder decrypted = new StringBuilder();
        int newPos;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            for (int j = 0; j < n; j++) {

                if (alphabet[j] == c) {
                    x = j;
                    newPos = (kInverse * (x + n - a)) % n;
                    y = alphabet[newPos];
                    decrypted.append(y);
                }
            }
        }
        System.out.println(decrypted);
    }

    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        caesar.decode(caesar.k, caesar.n, caesar.a);
        caesar.encode(caesar.text, 5,14);
//        caesar.encode(caesar.text, caesar.k, caesar.a);

    }
}
