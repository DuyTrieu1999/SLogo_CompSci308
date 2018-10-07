API Critique
===

### Names

Allen Qiu (asq3@duke.edu)

Brooke Keene (bzk2@duke.edu)

Duy Trieu (dvt5@duke.edu)
Yunhao Qing (yq50@duke.edu)

## Simulations


## Configurations


=======
### Evaluating Team 4's code:
```
package cellsociety;
public abstract class Cell { 
    public Cell(int state,int row, int col, String cellShape,int gridRows, int gridCols,String gridType) 
    public int getGridRows()
    public int getGridCols()
    public int getCurrentState() 
    public int getRows() 
    public int getCols() 
    public void setFutureState(int state) 
    public List<int[]> getNeighbors(Cell[][] grid) 
    public void react(Cell[][] mygrid) 
    public Polygon getMyShape()return myShape;
}
```

#### Should not be part of the API
* This team's design is very good and we did not think there were any methods that needed to be made private

#### Should be in internal API
* We also feel that this team created a good design and did not have any methods that another aspect of the program would not need

#### Should be in external API
* Cell
    * A Cell may need to be instantiated by the UI manager when it starts the program.
* getGridRows()
    * The UI manager may need the number of rows to implement an infinite edge or other extended applications such as when users click on cells
* getGridCols()
    * The UI manager may need the number of cols to implement an infinite edge or other extended applications such as when users click on cells
* getNeighbors()
    * In determing next states for cell, this class will be called in other by simulation classes. 
* getCurrentState()
    * In determing next states for cell, this class will be called in other by simulation classes. 
* react()
    * The UI manager may need to toggle the next step in the animation
* getMyShape()
    * The UI manager may need to display the shape of the cell
* setFutureState()
    * The UI manager may need to set a future state so that the user can change a cell state while it is running

* We did not understand the distinction between getGridRows and getRows and likewise getGridCols and getCols.

### Classification of 6 APIs

#### Simulation
* Internal


* External
    * public Cell[][] getGrid(File file)
    * public SegregationCell(int state, int row, int col,int gridRows,int gridCols, String cellShape,String gridType,double satisfactionRate) 
    * public PredatorPreyCell(int state, int row, int col,int gridRows,int gridCols, String cellShape,String gridType, int breedingTime)
    * public FireCell (int state,int row, int col,int gridRows, int gridCols, String cellShape,String gridType,double probCatch) 
    * public void updateColor()
    * public void update(Cell[][] grid) 
    * public void update(Cell[][] grid) 
    * public static List<String>getDataFields()return dataFields;}
    * public static String getSimulationType()return simulationType;}
    * public void react(Cell[][]grid)
    * public LifeCell(int state, int row, int col,int gridRows, int gridCols,String cellShape,String gridType) 

    * public Cell(int state,int row, int col, String cellShape,int gridRows, int gridCols,String gridType) 
    * public int getGridRows()
    * public int getGridCols()
    * public int getCurrentState() 
    * public int getRows() 
    * public int getCols() 
    * public void setFutureState(int state) 
    * public List<int[]> getNeighbors(Cell[][] grid) 
    * public void react(Cell[][] mygrid) 
    * public Polygon getMyShape()


#### Configuration
* Internal
    * public XMLException (Throwable cause, String message, Object ... values) 
    * public XMLException (Throwable cause) 
* External
    * public String getLastAnimationTitle()
    * public String getLastAnimationAuthor()
    * public String getCurrentTitle()
    * public String getCurrentAuthor()
    * public void step() 
    * public void loadAnimation(File file) 
    * public void saveAnimation(File file)
    * public static List<String>getDataFields()
    * public static String getSimulationType()
    *  public void saveSimulationState(Cell[][] grid, File currentFile, String newFilePath) 
    *  public int getGridRows()return gridRows;}
    *  public int getGridCols()return gridCols;}
    *  public boolean shouldRandomlyGenerate(File dataFile) 
    *  public XMLParser (String type) 
    * public void parseXMLHeader(File dataFile)
    *  public  String getCurrentAnimation()
    *  public String getCurrentAuthor()
    *   public HashMap<String, String> getSimulationMap()
    *  public Cell[][] getRPSGrid(File dataFile)throws IllegalArgumentException
    *  public Cell[][] getRPSGridWithStates(File dataFile) throws IllegalArgumentException
    *  public Cell[][] getPredatorGrid(File dataFile) throws IllegalArgumentException
    *  public Cell[][] getPredatorGridWithStates(File dataFile) throws IllegalArgumentException
    *  public Cell[][]getFireGrid(File dataFile) throws IllegalArgumentException 
    *   public Cell[][] getFireGridWithStates(File dataFile) throws IllegalArgumentException 
    *    public Cell[][] getSegregationGrid(File dataFile) throws IllegalArgumentException
    *   public Cell[][] getSegregationGridWithStates(File dataFile) throws IllegalArgumentException 
    *   public Cell[][] getLifeCellGrid(File dataFile) throws IllegalArgumentException
    *   public Cell[][] getLifeCellGridWithStates(File dataFile) throws IllegalArgumentException 
    *  public RockPaperScissorCell(int state, int row, int col,int gridRows, int gridCols,String cellShape,String gridType)
    * public void updateColor()
    * public void update(Cell[][] grid) 
    * public void react(Cell[][]grid)
    * public static List<String>getDataFields()
    * public static String getSimulationType()



#### Visualization
* Internal
     * public double getMilDelay()
* External
    * public static void playAnimation()
    * public static void stopAnimation() 
    * public MenuController( Group root)
    * public SimulationController
    * public MenuBar setMenu(Stage stage)
