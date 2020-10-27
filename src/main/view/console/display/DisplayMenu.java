package main.view.console.display;

public class DisplayMenu implements iDisplay {

	@Override
	public void printHelp() {
		defaultPrintHelp();
		System.out.println("'opret' for at tilføjer en ny person");
		System.out.println("'view' gå til view måde");
		System.out.println("'search' gå til søg måde");
		System.out.println("'status' se hvor mange der er registreret");
		System.out.println("'file' gå til file måde så man kan gemme og load csv filer");
	}

	@Override
	public void printView() {
	}

}
