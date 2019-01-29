// 855. Exam Room

// 解法1: TreeSet
// 解法2: PriorityQueue
public class ExamRoom {

    public void run() {
        ExamRoom exam = new ExamRoom(10);
        System.out.println(exam.seat());
        System.out.println(exam.seat());
        System.out.println(exam.seat());
        System.out.println(exam.seat());
        exam.leave(4);
        System.out.println(exam.seat());
        System.out.println("123");
    }

    // 简单解法, 用TreeSet记录目前在考试的学生座位号.
    // seat()方法中, 遍历一遍所有的座位, 计算两个student得出距离最大的座位.
    // corner case是左右两边:
    // 比如对于N=20, 当前座位是{3,5,6,8,15}
    // 最左边的空档是0～3,  prev == -1
    // 最右边的空档是15～20, student == N
    // 这两种情况要单独处理.
    //
    // leave()方法, 直接从TreeSet中删除就好了.
    // seat()方法是O(N), leave()方法是O(logN)
    class ExamRoom {

        TreeSet<Integer> students;
        int N;

        public ExamRoom(int N) {
            this.students = new TreeSet<>();
            this.students.add(N);
            this.N = N;
        }

        public int seat() {
            if(students.size() == 0) {
                students.add(0);
                return 0;
            }

            int prev = -1, dist = 0, spot = 0;
            for(int student : students) {
                // 第一个学生, 前面没有任何学生
                // 这种情况下, dist就是0到student
                // spot就是0
                if(prev == -1) {
                    if(student > dist) {
                        dist = student;
                        spot = 0;
                    }
                } 
                // 最后一个学生N
                // 这种情况下, dist就是student到N-1
                // spot就是N-1
                else if(student == N) {
                    if(N-1-prev > dist) {
                        dist = N-1-prev;
                        spot = N-1;
                    }
                }
                // 正常的情况，左右两边都在0～N-1范围内
                else
                {
                    int diff = (student - prev) / 2;
                    if(diff > dist) {
                        dist = diff;
                        spot = prev + (student - prev) / 2;
                    }
                }

                prev = student;
            }

            students.add(spot);
            return spot;
        }

        public void leave(int p) {
            students.remove(p);
        }
    }

}
