class BlobsPattern {
    public static void doSomething(String pattern, String blobs) {
      StringBuilder sb = new StringBuilder();
      int count = 0, total = 0;
      int j = 0, k = 0;
      char blobsArray[] = blobs.toCharArray();
  
      for (int i = 0; i < blobsArray.length; i++) {
        int ch = blobsArray[i];
  
        if (ch == '|') {
          sb.append(count);
          sb.append('|');
          total += count;
          count = 0;
          j = i + 1;
          k = 0;
        }
  
        if (ch == pattern.charAt(k)) {
          k++;
          if (k == pattern.length()) {
            count++;
            i = j;
            j++;
            k = 0;
          }
        }
  
        else {
          k = 0;
          j = i + 1;
        }
      }
  
      sb.append(count);
      sb.append('|');
      total += count;
      sb.append(total);
  
      System.out.println(sb.toString());
    }
  
    public static void main(String[] args) {
      doSomething("bc", "bcdfbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef234223bc32");
    }
  }