package roman.taska4;

public class Main {
    public static void main(String[] args){
        DB db = new DB();
        //db.Register("admin", "admin", "Nill Pet", "I am administrator!");
        //db.Register("kirill", "1", "Суханов Кирилл Андреевич", "Всем Привет!");
        //db.Register("alex", "1", "Агольцов Александр Сергеевич", "Привет, Кирилл!");
        //db.Register("pes", "1", "Агофонов Андрей Чейтович", "Я тут!");
        db.Login("kirill", "1");
        db.DisplayMessage();
        db.TopByTime(10, Boolean.TRUE);
        db.DisplayCount();
        db.DisplayAllMessage();
        db.SetNewMessage("Я Кирилл!");
        db.DisplayAllMessage();
        //db.ClearDB();
        db.Logout();
    }
}
