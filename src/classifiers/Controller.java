package classifiers;

import javax.swing.SwingUtilities;
import java.io.*;

public class Controller {
	private static final String FILENAME = "C:\\Users\\Asuss\\workspace\\classifiers\\output.txt";
	
	public Controller(int numOmegas){
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		JGraphAdapterDemo jg = new JGraphAdapterDemo(10);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jg.createAndShowGui();
                
            }
        });
		ProbabilityMatrix pm = new ProbabilityMatrix(2000);
		
		GenerateSamples gs = new GenerateSamples(numOmegas,2000,jg,pm);
		
		for(int i = 0; i < numOmegas; i++){
			Omega o = new Omega(10);
			gs.addOmega(o);
		}
		
		gs.genSamples();
		
		try{
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write("Probability Matrix:\n");
			bw.write(pm.toString());
			bw.write("\n");
			for(int i = 0; i < numOmegas; i++){
				bw.write("OMEGA " + i + ":\n");
				bw.write(gs.getOmegas().get(i).toString());
				bw.write("\n");
			}
			
			bw.write(gs.toString());
			bw.write("\n");
			
			bw.close();
			fw.close();
			System.out.println("HI");
			System.out.println(pm);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Controller c = new Controller(2);
	}

}
