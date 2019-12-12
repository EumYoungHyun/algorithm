import java.util.*;
class ���α׷��ӽ�_������_������ {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());//supply�������� ����
        int index=0;
        for(int i=0;i<k;i++){
            if(index<dates.length && i==dates[index]){//���޷������� ��������
                q.add(supplies[index]);
                index++;
            }
            
            if(stock==0){//��� 0�̵Ǵ� ������ ���� ���޷��� �����ָ� ������
                stock+=q.poll();
                answer++;
            }
            stock--;
        }
        return answer;
    }
}