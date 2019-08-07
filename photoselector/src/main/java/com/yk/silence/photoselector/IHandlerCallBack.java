package com.yk.silence.photoselector;

import java.util.List;

/**
 * IHandlerCallBack
 */

public interface IHandlerCallBack {

    void onStart();

    void onSuccess(List<String> photoList);

    void onCancel();

    void onFinish();

    void onError();

}
