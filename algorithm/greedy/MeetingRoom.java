import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Meeting[] meetingArr = new Meeting[n];
    for(int i=0; i<meetingArr.length; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      meetingArr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

  }
  
}
class Meeting {
  int start;
  int end;
  Meeting(int start, int end){
    this.start = start;
    this.end = end;
  }
  @Override
  public String toString(){
    return "start: "+ this.start + " // end: "+this.end;
  }

  static void printMeetingArr(Meeting[] meetings){
    for(Meeting meeting : meetings){
      System.out.println(meeting.toString());
    }
  }
}
