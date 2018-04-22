package me.kamili.rachid.nearbyeventsapp.view.base;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}