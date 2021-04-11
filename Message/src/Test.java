import java.util.Arrays;
import java.util.Scanner;


class Message{
	public String s;
	public Message(String str) {s = str;}
	public int countWords() {
		int k = 0;
		String s1 = s;
		while(s1.length() != 0) {
			String[] str = s1.split(" ", 2);
			if (str[0].length() != 0) {k++;}
			if (str.length > 1) {
				s1 = str[1];
			} else {
				s1 = "";
			}
		}
		return k;
	}
	public String reverse() {
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length/2; i++) {
			char t = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = t;
		}
		String s1 = new String(a);
		return s1;
	}
	public int count(char c) {
		int i = 0, k = 0;
		while(i != -1) {
			i = s.indexOf(c, i + 1);
			//System.out.println(i);
			if (i != -1) {k++;}
		}
		return k;
	}
	public String seria() {
		String s1 = s, ser = "";
		boolean t = false;
		while(s1.length() != 0) {
			String[] str = s1.split(" ", 2);
			if (str[0].length() != 0) {
				if(t) {ser = str[0]; break;}
				if (str[0].toLowerCase().equals("серия")) {
					t = true;
				}
			}
			if (str.length > 1) {
				s1 = str[1];
			} else {
				s1 = "";
			}
		}
		return ser;
	}
	public String nomer() {
		String s1 = s, num = "";
		boolean t = false;
		while(s1.length() != 0) {
			String[] str = s1.split(" ", 2);
			if (str[0].length() != 0) {
				if(t) {num = str[0]; break;}
				if (str[0].equals("№")) {
					t = true;
				} else if(str[0].charAt(0) == '№') {
					num = str[0].substring(1);
					break;
				}
			}
			if (str.length > 1) {
				s1 = str[1];
			} else {
				s1 = "";
			}
		}
		return num;
	}
}

public class Test {
	public static void main(String[] args) {
		String s;
		s = "a";
		Message m = new Message("  a  b c    a ");
		System.out.println(m.countWords());
		System.out.println(m.reverse());
		System.out.println(m.count('a'));
		Message m1 = new Message("Паспорт СеРия 6655 выдан");
		System.out.println(m1.seria());
		m1 = new Message("Паспорт СЕРИЯ 6655");
		System.out.println(m1.seria());
		m1 = new Message("Паспорт сериЯ");
		System.out.println(m1.seria());
		m1 = new Message("Паспорт СеРия 6655  №1111 выдан");
		System.out.println(m1.nomer());
		m1 = new Message("Паспорт СеРия 6655  № 1111");
		System.out.println(m1.nomer());
		m1 = new Message("Паспорт СеРия 6655  №");
		System.out.println(m1.nomer());
	}
}
