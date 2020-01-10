package com.mdtech.tsw.api.admin.authority;

import com.mdtech.tsw.common.context.Context;
import com.mdtech.tsw.common.context.Contexts;
import com.mdtech.tsw.common.context.SessionWrap;

public class AdminContext {

    public static AdminSessionWrap getSessionWrap() {
        Context context = Contexts.get();
        if (context == null) {
            return null;
        }
        SessionWrap session = context.getSession();
        if (session == null) {
            return null;
        }
        if (!(session instanceof AdminSessionWrap)) {
            return null;
        }
        return (AdminSessionWrap) session;
    }


}
