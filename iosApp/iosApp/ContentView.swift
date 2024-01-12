import SwiftUI
import shared

struct AppScreen : UIViewControllerRepresentable {
    
    func makeUIViewController(context: Context) -> UIViewController {
        return ComposeWrapper.shared.composeViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
}

struct ContentView: View {
    
	var body: some View {
        AppScreen()
            .ignoresSafeArea()
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

