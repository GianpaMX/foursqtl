package com.github.juansimp.foursqtl.model;

import android.content.Intent;

public interface Bean {
    public long getId();
    public void setData(Object[] data);
    public Intent toIntent();
}
