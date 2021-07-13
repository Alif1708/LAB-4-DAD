
public class Translator {
	
		
	
	public String chooseLanguage(int option, int text)
	{
		String result="";
		
		switch (option)
		{
		
			case 0 :
				result=bahasaMelayu(text);
				break;
			case 1 :
				result=Korean(text);
				break;
			case 2 :
				result=Arabic(text);
				break;
			default:
				System.out.print("Option error.");
										
		}
		return result;
		
	}
	
	private String bahasaMelayu (int text)
	{
		String BM = "";
		switch (text)
		{
		
			case 0 :
				BM= "Selamat pagi";
				break;
			case 1 :
				BM = "Selamat malam";
				break;
			case 2 :
				BM = "Apa khabar?";
				break;
			case 3 :
				BM = "Terima kasih";
				break;
			case 4 :
				BM = "Selamat tinggal";
				break;
			case 5 :
				BM ="Ada apa?";
				break;
			default:
				System.out.print("Bahasa Melayu error.");
										
		}
		
		return BM;
	}
	
	private String Korean (int text)
	{
		
		String korean = "";
		switch (text)
		{
		
			case 0 :
				korean= "좋은 아침";
				break;
			case 1 :
				korean = "안녕히 주무세요";
				break;
			case 2 :
				korean = "어떻게 지내세요?";
				break;
			case 3 :
				korean = "감사합니다";
				break;
			case 4 :
				korean = "안녕";
				break;
			case 5 :
				korean = "뭐야?";
				break;
			default:
				System.out.print("Korean error.");
										
		}
		return korean;
		
	}
	
	
	private String Arabic (int text)
	{
		
		String arabic = "";
		switch (text)
		{
		
			case 0 :
				arabic= " الخير صباح ";
				break;
			case 1 :
				arabic = "مساؤك طاب";
				break;
			case 2 :
				arabic = "حالك؟ كيف";
				break;
			case 3 :
				arabic = "لك شكر";
				break;
			case 4 :
				arabic = "السالمة مع";
				break;
			case 5 :
				arabic = "أخبارك؟ ما";
				break;
			default:
				System.out.print("Arabic error.");
										
		}
		return arabic;
		
	}
	
	
	
	

}
