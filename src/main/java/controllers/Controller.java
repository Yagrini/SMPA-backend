package controllers;

public interface Controller {

    /**
     * Display a listing of the resource.
     */
    public Object index();

    /**
     * Show the form for creating a new resource.
     */
    public Object create();

    /**
     * Store a newly created resource in storage
     */
    public Object store(Object request);

    /**
     * Display the specified resource.
     */
    public Object show(int id);

    /**
     * Show the form for editing the specified resource.
     */
    public Object edit(int id);

    /**
     * Update the specified resource in storage.
     */
    public Object update(Object request, int id);

    /**
     * Remove the specified resource from storage.
     */
    public Object destroy(int id);
}
