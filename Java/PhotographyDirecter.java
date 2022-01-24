class PhotographyDirecter {
  
    public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
        int[] P = new int[N + 1], B = new int[N + 1];
        int artisticPhotos = 0;

        for(int i = 1; i <= N; i++) {
            char photo = C.charAt(i - 1);
            P[i] = P[i - 1] + ((photo == 'P') ? 1 : 0);
            B[i] = B[i - 1] + ((photo == 'B') ? 1 : 0);
        }

        for(int i = 0; i < N; i++) {
            if(C.charAt(i) == 'A') {
                int frontMin = (i + X) < N ? (i + X) : N;
                int frontMax = (i + Y + 1) < N ? (i + Y + 1) : N;
                int backMin = (i - Y) > 0 ? (i - Y ) : 0;
                int backMax = (i - X + 1) > 0 ? (i - X + 1) : 0;

                artisticPhotos += (P[backMax] - P[backMin]) * (B[frontMax] - B[frontMin]);
                artisticPhotos += (B[backMax] - B[backMin]) * (P[frontMax] - P[frontMin]);
            }
        }

        return artisticPhotos;
    }

    public static void main(String[] args) {
        int N = 8;
        String C = ".PBAAP.B";
        int X = 1;
        int Y = 3;

        System.out.println(getArtisticPhotographCount(N, C, X, Y));
    }
}