package com.antran.expressfootball.loading;

public class LoadingController {

	private final String TAG = "LoadingController";

	private LoadingView loadingView;
	private LoadingControllerListener listener;
	private int proccesses = 0;
	
	public LoadingController(LoadingView loadingView, LoadingControllerListener listener) {
		this.loadingView = loadingView;
		this.listener = listener;
	}
	
	public void showLoading(){
		if(!loadingView.isShowing()){
			loadingView.show();
			listener.onShow();
		} else {
            proccesses++;
        }
	}
	
	public void hideLoading(){
		if(loadingView.isShowing() && proccesses == 0){
			loadingView.dismiss();
			listener.onHide();
		} else {
            proccesses--;
        }
	}
}
