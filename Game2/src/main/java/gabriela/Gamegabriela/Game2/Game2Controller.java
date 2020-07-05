package gabriela.Gamegabriela.Game2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Game2Controller {
	@RequestMapping("/Gold")
	public String gold(HttpSession sesion) {
		Double gold;
		ArrayList<String> act;
		
		if(sesion.getAttribute("gold")==null) {
			gold=0.0;
			act = new ArrayList<String>();
			sesion.setAttribute("gold", gold);
			sesion.setAttribute("act", act);
		}
		else {
			gold=(Double) sesion.getAttribute("gold");
			act= (ArrayList<String>) sesion.getAttribute("act");
			sesion.setAttribute("gold", gold);
			sesion.setAttribute("act", act);
		}
		
		if(gold<-200) {
			return "redirect:/prision";
		}
		else {
			return "index.jsp";
		}
	}
	
	@RequestMapping(value="/Farm", method=RequestMethod.POST)
	public String farm(HttpSession sesion, @RequestParam(value="farm", required=false) String farm) {
		
		Date fecha = new Date();
		
		Double gold = (Double) sesion.getAttribute("gold");
		ArrayList<String> act = (ArrayList<String>) sesion.getAttribute("act");
		Double earns;
		
		earns = Math.floor(Math.random()*(20-10+1)+10);
		gold=(Double) sesion.getAttribute("gold") + earns;
		act = (ArrayList<String>) sesion.getAttribute("act");
		sesion.setAttribute("gold", gold);
		String activity = "You entered a Farm and earned " + earns+ " Gold " + formato(fecha, "(MMMM d'rd' yyyy hh:mm aa)");
		act.add(activity);
		sesion.setAttribute("listActivities", act);
		
		return "redirect:/Gold";
		
	}
	
	@RequestMapping(value="/Cave", method=RequestMethod.POST)
	public String cave(HttpSession sesion, @RequestParam(value="cave", required=false) String cave) {
		
		Date fecha = new Date();
		
		Double gold = (Double) sesion.getAttribute("gold");
		ArrayList<String> act = (ArrayList<String>) sesion.getAttribute("act");
		Double earns;
		
		earns = Math.floor(Math.random()*(10-5+1)+5);
		gold=(Double) sesion.getAttribute("gold") + earns;
		act = (ArrayList<String>) sesion.getAttribute("act");
		sesion.setAttribute("gold", gold);
		String activity = "You entered a Cave and earned " + earns+ " Gold " + formato(fecha, "(MMMM d'rd' yyyy hh:mm aa)");
		act.add(activity);
		sesion.setAttribute("listActivities", act);
		
		return "redirect:/Gold";
		
	}
	
	
	@RequestMapping(value="House", method=RequestMethod.POST)
	public String house(HttpSession sesion, @RequestParam(value="house", required=false) String house) {
		
		Date fecha = new Date();
		
		Double gold = (Double) sesion.getAttribute("gold");
		ArrayList<String> act = (ArrayList<String>) sesion.getAttribute("act");
		Double earns;
		
		earns = Math.floor(Math.random()*(5-2+1)+2);
		gold=(Double) sesion.getAttribute("gold") + earns;
		act = (ArrayList<String>) sesion.getAttribute("act");
		sesion.setAttribute("gold", gold);
		String activity = "You entered a House and earned " + earns+ " Gold " + formato(fecha, "(MMMM d'rd' yyyy hh:mm aa)");
		act.add(activity);
		sesion.setAttribute("listActivities", act);
		
		return "redirect:/Gold";
		
	}
	
	@RequestMapping(value="/Casino", method=RequestMethod.POST)
	public String casino(HttpSession sesion, @RequestParam(value="casino", required=false) String casino) {
		
		Date fecha = new Date();
		
		Double gold = (Double) sesion.getAttribute("gold");
		ArrayList<String> act = (ArrayList<String>) sesion.getAttribute("act");
		Double earns;
		
		earns = Math.floor(Math.random()*(50-(-50)+1)+(-50));
		gold=(Double) sesion.getAttribute("gold") + earns;
		act = (ArrayList<String>) sesion.getAttribute("act");
		sesion.setAttribute("gold", gold);
		
		if(earns>0) {
			String activity = "You entered a Casino and earned " + earns + " Gold " + formato(fecha, "(MMMM d'rd' yyyy hh:mm aa)");
			act.add(activity);
			sesion.setAttribute("listActivities", act);
		}
		else {
			String activity = "You entered a Casino and lost " + earns + " Gold. Ouch! " + formato(fecha, "(MMMM d'rd' yyyy hh:mm aa)");
			act.add(activity);
			sesion.setAttribute("listActivities", act);
		}
		
		return "redirect:/Gold";
		
	}
	
	@RequestMapping(value="Spa", method=RequestMethod.POST)
	public String spa(HttpSession sesion, @RequestParam(value="spa", required=false) String spa) {
		
		Date fecha = new Date();
		
		Double gold = (Double) sesion.getAttribute("gold");
		ArrayList<String> act = (ArrayList<String>) sesion.getAttribute("act");
		Double earns;
		
		earns = Math.floor(Math.random()*(20-5+1)+5);
		gold=(Double) sesion.getAttribute("gold") - earns;
		act = (ArrayList<String>) sesion.getAttribute("act");
		sesion.setAttribute("gold", gold);
		String activity = "You entered a Spa and lost " + earns+ " Gold " + formato(fecha, "(MMMM d'rd' yyyy hh:mm aa)");
		act.add(activity);
		sesion.setAttribute("listActivities", act);
		
		return "redirect:/Gold";
		
	}
	
	@RequestMapping("/Reset")
	public String reset(HttpSession sesion, @RequestParam(value="reset", required=false) String reset) {
		Double gold = (Double) sesion.getAttribute("gold");
		ArrayList<String> act = (ArrayList<String>) sesion.getAttribute("act");
		
		gold=0.0;
		act.clear();
		
		sesion.setAttribute("gold", gold);
		sesion.setAttribute("listActivities", act);
		
		return "redirect:/Gold";
	}
	
	@RequestMapping("/prision")
	public String prision() {
		return "prision.jsp";
	}
	
	//Metodo para dar formato a fecha y hora
		public String formato(Date var,String forma) {
			String fecha;
			String strDateFormat = forma;
			SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
			fecha = sdf.format(var);
			return fecha;
	}
}
