/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema19_prueba;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

/**
 *
 * @author DAW_16_AlbertoMarun
 */
public class Prueba19 {
    public static void main(String[] args){
        ObjectContainer db = null;
        
        try{
            db = Db4oEmbedded.openFile(
                Db4oEmbedded.newConfiguration(), "data_base_prueba.db4o"
            );
            
            Person alberto = new Person("Alberto", "Marun", 19);
            db.store(alberto);
            
            Person ana = new Person("Ana", "Marulanda", 19);
            db.store(ana);
            
            Person juan = new Person("Juan", "Montero", 18);
            db.store(juan);
            
            Person fede = new Person("Federico", "Palma", 20);
            db.store(fede);
            
            Person example = new Person();
            
            Query query = db.query();
            query.constrain(Person.class);
            
            // EJEMPLO DE AND
            Constraint greater_than_eighteen = query.descend("age").constrain(18).greater();            
            Constraint co_name = query.descend("name").constrain("CO").like();
            
            query.descend("age").constrain(18).greater().and(co_name);
            
            // EJEMPLO DE STRINGS
            // query.descend("name").constrain("Federico").equal();
            // query.descend("name").constrain("CO").like();
            
            // EJEMPLO DE ENTEROS
            /*
            query.descend("age").constrain(18).greater();
            query.descend("age").constrain(20).smaller();
            */
            ObjectSet oset = query.execute();
            
            while(oset.hasNext()){
                System.out.println(oset.next());
            }
            
            /**
            while(oset.hasNext()){
                Person persona = (Person) oset.next();
                System.out.println(persona);
            }
            
            
            System.out.println("___________________");
            
            fede.setName("Donald");
            fede.setSurname("Trump");
            
            db.store(fede);
            db.delete(ana);
            
            oset = db.queryByExample(example);
            
            while(oset.hasNext()){
                System.out.println(oset.next());
            }
            */
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        finally{
            if(db != null){
                db.close();   
            }
        }
    }

    private static Object contstrain(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
