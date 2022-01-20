stk.v.11.0
WrittenBy    STK_v11.2.0
BEGIN Scenario
    Name            Inserimento

BEGIN Epoch

    Epoch        5 Jan 2022 11:00:00.000000000
    SmartEpoch
	BEGIN	EVENT
			Epoch	5 Jan 2022 11:00:00.000000000
			EventEpoch
				BEGIN	EVENT
					Type	EVENT_LINKTO
					Name	AnalysisStartTime
				END	EVENT
			EpochState	Implicit
	END	EVENT


END Epoch

BEGIN Interval

Start                   5 Jan 2022 11:00:00.000000000
Stop                    6 Jan 2022 11:00:00.000000000
    SmartInterval
	BEGIN	EVENTINTERVAL
			BEGIN Interval
				Start	5 Jan 2022 11:00:00.000000000
				Stop	6 Jan 2022 11:00:00.000000000
			END Interval
			IntervalState	Explicit
	END	EVENTINTERVAL

EpochUsesAnalStart      No
AnimStartUsesAnalStart  Yes
AnimStopUsesAnalStop    Yes

END Interval

BEGIN EOPFile

    EOPFilename     EOP-v1.1.txt

END EOPFile

BEGIN GlobalPrefs

    SatelliteNoOrbWarning    No
    MissilePerigeeWarning    No
    MissileStopTimeWarning   No
    AircraftWGS84Warning     Always
END GlobalPrefs

BEGIN CentralBody

    PrimaryBody     Earth

END CentralBody

BEGIN CentralBodyTerrain

    BEGIN CentralBody
        Name            Earth
        UseTerrainCache Yes
        TotalCacheSize  402653184

        BEGIN StreamingTerrain
            UseCurrentStreamingTerrainServer     Yes
            StreamingTerrainTilesetName    world
            StreamingTerrainServerName           assets.agi.com/stk-terrain/
            StreamingTerrainAzimuthElevationMaskEnabled       No
            StreamingTerrainObscurationEnabled       No
            StreamingTerrainCoverageGridObscurationEnabled       No
        END StreamingTerrain
    END CentralBody

END CentralBodyTerrain

BEGIN StarCollection

    Name     Hipparcos 2 Mag 6

END StarCollection

BEGIN ScenarioLicenses
    Module    AMMv11.2
    Module    ASTGv11.2
    Module    CATv11.2
    Module    CHAINSv11.2
    Module    CONv11.2
    Module    COVv11.2
    Module    CRMv11.2
    Module    Commv11.2
    Module    DISv11.2
    Module    EOIRv11.2
    Module    HRMv11.2
    Module    MexServv11.2
    Module    RT3Clientv11.2
    Module    RdrAdvEnv11.2
    Module    SEETv11.2
    Module    STKCAP
    Module    STKExpertv11.2
    Module    STKIntegrationv11.2
    Module    STKParallelComputingv11.2
    Module    STKProfessionalv11.2
    Module    STKv11.2
    Module    TERNv11.2
    Module    TIREMv11.2
    Module    UPropv11.2
    Module    Underseav11.2
END ScenarioLicenses

BEGIN WebData
        EnableWebTerrainData    No
        SaveWebTerrainDataPasswords    No
        BEGIN ConfigServerDataList
            BEGIN ConfigServerData
                Name "globeserver.agi.com"
                Port 80
                DataURL "bin/getGlobeSvrConfig.pl"
            END ConfigServerData
        END ConfigServerDataList
END WebData

BEGIN Extensions
    
    BEGIN ClsApp
		RangeConstraint         5000.000
		ApoPeriPad              30000.000
		OrbitPathPad            100000.000
		TimeDistPad             30000.000
		OutOfDate               2592000.000
		MaxApoPeriStep          900.000
		ApoPeriAngle            0.785
		UseApogeePerigeeFilter  Yes
		UsePathFilter           No
		UseTimeFilter           No
		UseOutOfDate            Yes
		CreateSats              No
		MaxSatsToCreate         500
		UseModelScale           No
		ModelScale              0.000
		UseCrossRefDb           Yes
		CollisionDB                     stkAllTLE.tce
		CollisionCrossRefDB             stkAllTLE.sd
		ShowLine                Yes
		AnimHighlight           Yes
		StaticHighlight         Yes
		UseLaunchWindow                         No
		LaunchWindowUseEntireTraj               Yes
		LaunchWindowTrajMETStart                0.000
		LaunchWindowTrajMETStop                 900.000
		LaunchWindowStart                       0.000
		LaunchWindowStop                        0.000
		LaunchMETOffset                         0.000
		LaunchWindowUseSecEphem                 No 
		LaunchWindowUseScenFolderForSecEphem    Yes
		LaunchWindowUsePrimEphem                No 
		LaunchWindowUseScenFolderForPrimEphem   Yes
    LaunchWindowIntervalPtr
	BEGIN	EVENTINTERVAL
			BEGIN Interval
				Start	5 Jan 2022 11:00:00.000000000
				Stop	6 Jan 2022 11:00:00.000000000
			END Interval
			IntervalState	Explicit
	END	EVENTINTERVAL

		LaunchWindowUsePrimMTO                  No 
		GroupLaunches                           No 
		LWTimeConvergence                       1.000e-03
		LWRelValueConvergence                   1.000e-08
		LWTSRTimeConvergence                    1.000e-04
		LWTSRRelValueConvergence                1.000e-10
		LaunchWindowStep                        300.000
		MaxTSRStep                              180.000
		MaxTSRRelMotion                         20.000
		UseLaunchArea                           No 
		LaunchAreaOrientation                   North
		LaunchAreaAzimuth                       0.000
		LaunchAreaXLimits                       -10000.000   10000.000
		LaunchAreaYLimits                       -10000.000   10000.000
		LaunchAreaNumXIntrPnts                  1
		LaunchAreaNumYIntrPnts                  1
		LaunchAreaAltReference                  Ellipsoid
		TargetSameStop                          No 
		SkipSurfaceMetric                       No 
		LWAreaTSRRelValueConvergence            1.000e-10
		AreaLaunchWindowStep                    300.000
		AreaMaxTSRStep                          30.000
		AreaMaxTSRRelMotion                     1.000
		ShowLaunchArea                          No 
		ShowBlackoutTracks                      No 
		ShowClearedTracks                       No 
		UseObjectForClearedColor                No 
		BlackoutColor                           #ff0000
		ClearedColor                             #ffffff
		ShowTracksSegments                      Yes
		ShowMinRangeTracks                      Yes
		MinRangeTrackTimeStep                   0.500000
		UsePrimStepForTracks                    Yes
		GfxTracksTimeStep                       30.000
		GfxAreaNumXIntrPnts                     1
		GfxAreaNumYIntrPnts                     1
		CreateLaunchMTO                         No 
		CovarianceSigmaScale                    3.000
		CovarianceMode                          None 
    END ClsApp
    
    BEGIN Units
		DistanceUnit		Kilometers
		TimeUnit		Seconds
		DateFormat		GregorianUTC
		AngleUnit		Degrees
		MassUnit		Kilograms
		PowerUnit		dBW
		FrequencyUnit		Gigahertz
		SmallDistanceUnit		Meters
		LatitudeUnit		Degrees
		LongitudeUnit		Degrees
		DurationUnit		Hr:Min:Sec
		Temperature		Kelvin
		SmallTimeUnit		Seconds
		RatioUnit		Decibel
		RcsUnit		Decibel
		DopplerVelocityUnit		MetersperSecond
		SARTimeResProdUnit		Meter-Second
		ForceUnit		Newtons
		PressureUnit		Pascals
		SpecificImpulseUnit		Seconds
		PRFUnit		Kilohertz
		BandwidthUnit		Megahertz
		SmallVelocityUnit		CentimetersperSecond
		Percent		Percentage
		AviatorDistanceUnit		NauticalMiles
		AviatorTimeUnit		Hours
		AviatorAltitudeUnit		Feet
		AviatorFuelQuantityUnit		Pounds
		AviatorRunwayLengthUnit		Kilofeet
		AviatorBearingAngleUnit		Degrees
		AviatorAngleOfAttackUnit		Degrees
		AviatorAttitudeAngleUnit		Degrees
		AviatorGUnit		StandardSeaLevelG
		SolidAngle		Steradians
		AviatorTSFCUnit		TSFCLbmHrLbf
		AviatorPSFCUnit		PSFCLbmHrHp
		AviatorForceUnit		Pounds
		AviatorPowerUnit		Horsepower
		SpectralBandwidthUnit		Hertz
		AviatorAltTimeUnit		Minutes
		AviatorSmallTimeUnit		Seconds
		AviatorEnergyUnit		kilowatt-hours
		BitsUnit		MegaBits
		RadiationDose		Rads
		MagneticFieldUnit		nanoTesla
		RadiationShieldThickness		Mils
		ParticleEnergy		MeV
    END Units
    
    BEGIN ReportUnits
		DistanceUnit		Kilometers
		TimeUnit		Seconds
		DateFormat		GregorianUTC
		AngleUnit		Degrees
		MassUnit		Kilograms
		PowerUnit		dBW
		FrequencyUnit		Gigahertz
		SmallDistanceUnit		Meters
		LatitudeUnit		Degrees
		LongitudeUnit		Degrees
		DurationUnit		Hr:Min:Sec
		Temperature		Kelvin
		SmallTimeUnit		Seconds
		RatioUnit		Decibel
		RcsUnit		Decibel
		DopplerVelocityUnit		MetersperSecond
		SARTimeResProdUnit		Meter-Second
		ForceUnit		Newtons
		PressureUnit		Pascals
		SpecificImpulseUnit		Seconds
		PRFUnit		Kilohertz
		BandwidthUnit		Megahertz
		SmallVelocityUnit		CentimetersperSecond
		Percent		Percentage
		AviatorDistanceUnit		NauticalMiles
		AviatorTimeUnit		Hours
		AviatorAltitudeUnit		Feet
		AviatorFuelQuantityUnit		Pounds
		AviatorRunwayLengthUnit		Kilofeet
		AviatorBearingAngleUnit		Degrees
		AviatorAngleOfAttackUnit		Degrees
		AviatorAttitudeAngleUnit		Degrees
		AviatorGUnit		StandardSeaLevelG
		SolidAngle		Steradians
		AviatorTSFCUnit		TSFCLbmHrLbf
		AviatorPSFCUnit		PSFCLbmHrHp
		AviatorForceUnit		Pounds
		AviatorPowerUnit		Horsepower
		SpectralBandwidthUnit		Hertz
		AviatorAltTimeUnit		Minutes
		AviatorSmallTimeUnit		Seconds
		AviatorEnergyUnit		kilowatt-hours
		BitsUnit		MegaBits
		RadiationDose		Rads
		MagneticFieldUnit		nanoTesla
		RadiationShieldThickness		Mils
		ParticleEnergy		MeV
    END ReportUnits
    
    BEGIN ConnectReportUnits
		DistanceUnit		Kilometers
		TimeUnit		Seconds
		DateFormat		GregorianUTC
		AngleUnit		Degrees
		MassUnit		Kilograms
		PowerUnit		dBW
		FrequencyUnit		Gigahertz
		SmallDistanceUnit		Meters
		LatitudeUnit		Degrees
		LongitudeUnit		Degrees
		DurationUnit		Hr:Min:Sec
		Temperature		Kelvin
		SmallTimeUnit		Seconds
		RatioUnit		Decibel
		RcsUnit		Decibel
		DopplerVelocityUnit		MetersperSecond
		SARTimeResProdUnit		Meter-Second
		ForceUnit		Newtons
		PressureUnit		Pascals
		SpecificImpulseUnit		Seconds
		PRFUnit		Kilohertz
		BandwidthUnit		Megahertz
		SmallVelocityUnit		CentimetersperSecond
		Percent		Percentage
		AviatorDistanceUnit		NauticalMiles
		AviatorTimeUnit		Hours
		AviatorAltitudeUnit		Feet
		AviatorFuelQuantityUnit		Pounds
		AviatorRunwayLengthUnit		Kilofeet
		AviatorBearingAngleUnit		Degrees
		AviatorAngleOfAttackUnit		Degrees
		AviatorAttitudeAngleUnit		Degrees
		AviatorGUnit		StandardSeaLevelG
		SolidAngle		Steradians
		AviatorTSFCUnit		TSFCLbmHrLbf
		AviatorPSFCUnit		PSFCLbmHrHp
		AviatorForceUnit		Pounds
		AviatorPowerUnit		Horsepower
		SpectralBandwidthUnit		Hertz
		AviatorAltTimeUnit		Minutes
		AviatorSmallTimeUnit		Seconds
		AviatorEnergyUnit		kilowatt-hours
		BitsUnit		MegaBits
		RadiationDose		Rads
		MagneticFieldUnit		nanoTesla
		RadiationShieldThickness		Mils
		ParticleEnergy		MeV
    END ConnectReportUnits
    
    BEGIN ReportFavorites
    END ReportFavorites
    
    BEGIN ADFFileData
    END ADFFileData
    
    BEGIN GenDb

		BEGIN Database
		    DbType       Satellite
		    DefDb        stkAllTLE.sd
		    UseMyDb      Off
		    MaxMatches   2000
		    Use4SOC      On

		BEGIN FieldDefaults

			BEGIN Field
				Name "SSC Number"
				Default "*"
			END Field

			BEGIN Field
				Name "Common Name"
				Default "*"
			END Field

		END FieldDefaults

		END Database

		BEGIN Database
		    DbType       City
		    DefDb        stkCityDb.cd
		    UseMyDb      Off
		    MaxMatches   2000
		    Use4SOC      On

		BEGIN FieldDefaults

			BEGIN Field
				Name "City Name"
				Default "*"
			END Field

		END FieldDefaults

		END Database

		BEGIN Database
		    DbType       Facility
		    DefDb        stkFacility.fd
		    UseMyDb      Off
		    MaxMatches   2000
		    Use4SOC      On

		BEGIN FieldDefaults

		END FieldDefaults

		END Database
    END GenDb
    
    BEGIN SOCDb
        BEGIN Defaults
        END Defaults
    END SOCDb
    
    BEGIN Msgp4Ext
    END Msgp4Ext
    
    BEGIN FileLocations
    END FileLocations
    
    BEGIN Author
	Optimize	No
	UseBasicGlobe	No
	SaveEphemeris	Yes
	SaveScenFolder	No
	BEGIN ExternalFileTypes
	    BEGIN Type
		FileType  Calculation Scalar
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Celestial Image
		Include    No
	    END Type
	    BEGIN Type
		FileType  Cloud
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  EOP
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  External Vector Data
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Globe
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Globe Data
		Include    No
	    END Type
	    BEGIN Type
		FileType  Map
		Include    No
	    END Type
	    BEGIN Type
		FileType  Map Image
		Include    No
	    END Type
	    BEGIN Type
		FileType  Marker/Label
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Model
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Object Break-up File
		Include    No
	    END Type
	    BEGIN Type
		FileType  Planetary Ephemeris
		Include    No
	    END Type
	    BEGIN Type
		FileType  Report Style Script
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Report/Graph Style
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Scalar Calculation File
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Terrain
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Volume Grid Intervals File
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  Volumetric File
		Include    Yes
	    END Type
	    BEGIN Type
		FileType  WTM
		Include    Yes
	    END Type
	END ExternalFileTypes
	ReadOnly	No
	ViewerPassword	No
	STKPassword	No
	ExcludeInstallFiles	No
	BEGIN ExternalFileList
	END ExternalFileList
    END Author
    
    BEGIN ExportDataFile
    FileType         Ephemeris
    IntervalType     Ephemeris
    TimePeriodStart  0.000000e+00
    TimePeriodStop   0.000000e+00
    StepType         Ephemeris
    StepSize         60.000000
    EphemType        STK
    UseVehicleCentralBody   Yes
    CentralBody      Earth
    SatelliteID      -200000
    CoordSys         ICRF
    NonSatCoordSys   Fixed
    InterpolateBoundaries  Yes
    EphemFormat      Current
    InterpType       9
    InterpOrder      5
    AttCoordSys      Fixed
    Quaternions      0
    ExportCovar      Position
    AttitudeFormat   Current
    TimePrecision      6
    CCSDSDateFormat    YMD
    CCSDSEphFormat     SciNotation
    CCSDSTimeSystem    UTC
    CCSDSRefFrame      ICRF
    UseSatCenterAndFrame   No
    IncludeCovariance      No
    IncludeAcceleration    No
    CCSDSFileFormat      KVN
    END ExportDataFile
    
    BEGIN Desc
    END Desc
    
    BEGIN RfEnv
<?xml version = "1.0" standalone = "yes"?>
<VAR name = "STK_RF_Environment">
    <SCOPE Class = "RFEnvironment">
        <VAR name = "Version">
            <STRING>&quot;1.0.0 a&quot;</STRING>
        </VAR>
        <VAR name = "ComponentName">
            <STRING>&quot;STK_RF_Environment&quot;</STRING>
        </VAR>
        <VAR name = "Description">
            <STRING>&quot;STK RF Environment&quot;</STRING>
        </VAR>
        <VAR name = "Type">
            <STRING>&quot;STK RF Environment&quot;</STRING>
        </VAR>
        <VAR name = "UserComment">
            <STRING>&quot;STK RF Environment&quot;</STRING>
        </VAR>
        <VAR name = "ReadOnly">
            <BOOL>false</BOOL>
        </VAR>
        <VAR name = "Clonable">
            <BOOL>true</BOOL>
        </VAR>
        <VAR name = "Category">
            <STRING>&quot;&quot;</STRING>
        </VAR>
        <VAR name = "PropagationChannel">
            <VAR name = "RF_Propagation_Channel">
                <SCOPE Class = "PropagationChannel">
                    <VAR name = "Version">
                        <STRING>&quot;1.0.0 a&quot;</STRING>
                    </VAR>
                    <VAR name = "ComponentName">
                        <STRING>&quot;RF_Propagation_Channel&quot;</STRING>
                    </VAR>
                    <VAR name = "Description">
                        <STRING>&quot;RF Propagation Channel&quot;</STRING>
                    </VAR>
                    <VAR name = "Type">
                        <STRING>&quot;RF Propagation Channel&quot;</STRING>
                    </VAR>
                    <VAR name = "UserComment">
                        <STRING>&quot;RF Propagation Channel&quot;</STRING>
                    </VAR>
                    <VAR name = "ReadOnly">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "Clonable">
                        <BOOL>true</BOOL>
                    </VAR>
                    <VAR name = "Category">
                        <STRING>&quot;&quot;</STRING>
                    </VAR>
                    <VAR name = "UseITU618Section2p5">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "UseCloudFogModel">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "CloudFogModel">
                        <VAR name = "ITU-R_P840-6">
                            <SCOPE Class = "CloudFogLossModel">
                                <VAR name = "Version">
                                    <STRING>&quot;1.0.0 a&quot;</STRING>
                                </VAR>
                                <VAR name = "ComponentName">
                                    <STRING>&quot;ITU-R_P840-6&quot;</STRING>
                                </VAR>
                                <VAR name = "Description">
                                    <STRING>&quot;ITU-R P840-6&quot;</STRING>
                                </VAR>
                                <VAR name = "Type">
                                    <STRING>&quot;ITU-R P840-6&quot;</STRING>
                                </VAR>
                                <VAR name = "UserComment">
                                    <STRING>&quot;ITU-R P840-6&quot;</STRING>
                                </VAR>
                                <VAR name = "ReadOnly">
                                    <BOOL>false</BOOL>
                                </VAR>
                                <VAR name = "Clonable">
                                    <BOOL>true</BOOL>
                                </VAR>
                                <VAR name = "Category">
                                    <STRING>&quot;&quot;</STRING>
                                </VAR>
                                <VAR name = "LiquidWaterDensityValueChoice">
                                    <STRING>&quot;Liquid Water Content Density Value&quot;</STRING>
                                </VAR>
                                <VAR name = "CloudCeiling">
                                    <QUANTITY Dimension = "DistanceUnit" Unit = "m">
                                        <REAL>3000</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "CloudLayerThickness">
                                    <QUANTITY Dimension = "DistanceUnit" Unit = "m">
                                        <REAL>500</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "CloudTemp">
                                    <QUANTITY Dimension = "Temperature" Unit = "K">
                                        <REAL>273.15</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "CloudLiqWaterDensity">
                                    <QUANTITY Dimension = "SmallDensity" Unit = "kg*m^-3">
                                        <REAL>0.0075</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "AnnualAveragePercentValue">
                                    <QUANTITY Dimension = "Percent" Unit = "unitValue">
                                        <REAL>0.01</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "MonthlyAveragePercentValue">
                                    <QUANTITY Dimension = "Percent" Unit = "unitValue">
                                        <REAL>0.01</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "LiqWaterAverageDataMonth">
                                    <INT>1</INT>
                                </VAR>
                            </SCOPE>
                        </VAR>
                    </VAR>
                    <VAR name = "UseTropoScintModel">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "TropoScintModel">
                        <VAR name = "ITU-R_P618-12">
                            <SCOPE Class = "TropoScintLossModel">
                                <VAR name = "Version">
                                    <STRING>&quot;1.0.0 a&quot;</STRING>
                                </VAR>
                                <VAR name = "ComponentName">
                                    <STRING>&quot;ITU-R_P618-12&quot;</STRING>
                                </VAR>
                                <VAR name = "Description">
                                    <STRING>&quot;ITU-R P618-12&quot;</STRING>
                                </VAR>
                                <VAR name = "Type">
                                    <STRING>&quot;ITU-R P618-12&quot;</STRING>
                                </VAR>
                                <VAR name = "UserComment">
                                    <STRING>&quot;ITU-R P618-12&quot;</STRING>
                                </VAR>
                                <VAR name = "ReadOnly">
                                    <BOOL>false</BOOL>
                                </VAR>
                                <VAR name = "Clonable">
                                    <BOOL>true</BOOL>
                                </VAR>
                                <VAR name = "Category">
                                    <STRING>&quot;&quot;</STRING>
                                </VAR>
                                <VAR name = "FadeDepthAverageTimeChoice">
                                    <STRING>&quot;Fade depth for the average year&quot;</STRING>
                                </VAR>
                                <VAR name = "ComputeDeepFade">
                                    <BOOL>false</BOOL>
                                </VAR>
                                <VAR name = "FadeOutage">
                                    <QUANTITY Dimension = "Percent" Unit = "unitValue">
                                        <REAL>0.001</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "PercentTimeRefracGrad">
                                    <QUANTITY Dimension = "Percent" Unit = "unitValue">
                                        <REAL>0.1</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "SurfaceTemperature">
                                    <QUANTITY Dimension = "Temperature" Unit = "K">
                                        <REAL>273.15</REAL>
                                    </QUANTITY>
                                </VAR>
                            </SCOPE>
                        </VAR>
                    </VAR>
                    <VAR name = "UseRainModel">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "RainModel">
                        <VAR name = "ITU-R_P618-12">
                            <SCOPE Class = "RainLossModel">
                                <VAR name = "Version">
                                    <STRING>&quot;1.0.0 a&quot;</STRING>
                                </VAR>
                                <VAR name = "ComponentName">
                                    <STRING>&quot;ITU-R_P618-12&quot;</STRING>
                                </VAR>
                                <VAR name = "Description">
                                    <STRING>&quot;ITU-R P618-12 rain model&quot;</STRING>
                                </VAR>
                                <VAR name = "Type">
                                    <STRING>&quot;ITU-R P618-12&quot;</STRING>
                                </VAR>
                                <VAR name = "UserComment">
                                    <STRING>&quot;ITU-R P618-12 rain model&quot;</STRING>
                                </VAR>
                                <VAR name = "ReadOnly">
                                    <BOOL>false</BOOL>
                                </VAR>
                                <VAR name = "Clonable">
                                    <BOOL>true</BOOL>
                                </VAR>
                                <VAR name = "Category">
                                    <STRING>&quot;&quot;</STRING>
                                </VAR>
                                <VAR name = "SurfaceTemperature">
                                    <QUANTITY Dimension = "Temperature" Unit = "K">
                                        <REAL>273.15</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "EnableDepolarizationLoss">
                                    <BOOL>false</BOOL>
                                </VAR>
                            </SCOPE>
                        </VAR>
                    </VAR>
                    <VAR name = "UseAtmosAbsorptionModel">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "AtmosAbsorptionModel">
                        <VAR name = "Simple_Satcom">
                            <SCOPE Class = "AtmosphericAbsorptionModel">
                                <VAR name = "Version">
                                    <STRING>&quot;1.0.1 a&quot;</STRING>
                                </VAR>
                                <VAR name = "ComponentName">
                                    <STRING>&quot;Simple_Satcom&quot;</STRING>
                                </VAR>
                                <VAR name = "Description">
                                    <STRING>&quot;Simple Satcom gaseous absorption model&quot;</STRING>
                                </VAR>
                                <VAR name = "Type">
                                    <STRING>&quot;Simple Satcom&quot;</STRING>
                                </VAR>
                                <VAR name = "UserComment">
                                    <STRING>&quot;Simple Satcom gaseous absorption model&quot;</STRING>
                                </VAR>
                                <VAR name = "ReadOnly">
                                    <BOOL>false</BOOL>
                                </VAR>
                                <VAR name = "Clonable">
                                    <BOOL>true</BOOL>
                                </VAR>
                                <VAR name = "Category">
                                    <STRING>&quot;&quot;</STRING>
                                </VAR>
                                <VAR name = "SurfaceTemperature">
                                    <QUANTITY Dimension = "Temperature" Unit = "K">
                                        <REAL>293.15</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "WaterVaporConcentration">
                                    <QUANTITY Dimension = "Density" Unit = "g*m^-3">
                                        <REAL>7.5</REAL>
                                    </QUANTITY>
                                </VAR>
                            </SCOPE>
                        </VAR>
                    </VAR>
                    <VAR name = "UseUrbanTerresPropLossModel">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "UrbanTerresPropLossModel">
                        <VAR name = "Two_Ray">
                            <SCOPE Class = "UrbanTerrestrialPropagationLossModel">
                                <VAR name = "Version">
                                    <STRING>&quot;1.0.0 a&quot;</STRING>
                                </VAR>
                                <VAR name = "ComponentName">
                                    <STRING>&quot;Two_Ray&quot;</STRING>
                                </VAR>
                                <VAR name = "Description">
                                    <STRING>&quot;Two Ray (Fourth Power Law) atmospheric absorption model&quot;</STRING>
                                </VAR>
                                <VAR name = "Type">
                                    <STRING>&quot;Two Ray&quot;</STRING>
                                </VAR>
                                <VAR name = "UserComment">
                                    <STRING>&quot;Two Ray (Fourth Power Law) atmospheric absorption model&quot;</STRING>
                                </VAR>
                                <VAR name = "ReadOnly">
                                    <BOOL>false</BOOL>
                                </VAR>
                                <VAR name = "Clonable">
                                    <BOOL>true</BOOL>
                                </VAR>
                                <VAR name = "Category">
                                    <STRING>&quot;&quot;</STRING>
                                </VAR>
                                <VAR name = "SurfaceTemperature">
                                    <QUANTITY Dimension = "Temperature" Unit = "K">
                                        <REAL>273.15</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "LossFactor">
                                    <REAL>1</REAL>
                                </VAR>
                            </SCOPE>
                        </VAR>
                    </VAR>
                    <VAR name = "UseCustomA">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "UseCustomB">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "UseCustomC">
                        <BOOL>false</BOOL>
                    </VAR>
                </SCOPE>
            </VAR>
        </VAR>
        <VAR name = "EarthTemperature">
            <QUANTITY Dimension = "Temperature" Unit = "K">
                <REAL>290</REAL>
            </QUANTITY>
        </VAR>
        <VAR name = "RainOutagePercent">
            <PROP name = "FormatString">
                <STRING>&quot;%#6.3f&quot;</STRING>
            </PROP>
            <REAL>0.1</REAL>
        </VAR>
        <VAR name = "ActiveCommSystem">
            <LINKTOOBJ>
                <STRING>&quot;None&quot;</STRING>
            </LINKTOOBJ>
        </VAR>
    </SCOPE>
</VAR>    END RfEnv
    
    BEGIN CommRad
    END CommRad
    
    BEGIN RadarCrossSection
<?xml version = "1.0" standalone = "yes"?>
<VAR name = "STK_Radar_RCS_Extension">
    <SCOPE Class = "RadarRCSExtension">
        <VAR name = "Version">
            <STRING>&quot;1.0.0 a&quot;</STRING>
        </VAR>
        <VAR name = "ComponentName">
            <STRING>&quot;STK_Radar_RCS_Extension&quot;</STRING>
        </VAR>
        <VAR name = "Description">
            <STRING>&quot;STK Radar RCS Extension&quot;</STRING>
        </VAR>
        <VAR name = "Type">
            <STRING>&quot;STK Radar RCS Extension&quot;</STRING>
        </VAR>
        <VAR name = "UserComment">
            <STRING>&quot;STK Radar RCS Extension&quot;</STRING>
        </VAR>
        <VAR name = "ReadOnly">
            <BOOL>false</BOOL>
        </VAR>
        <VAR name = "Clonable">
            <BOOL>true</BOOL>
        </VAR>
        <VAR name = "Category">
            <STRING>&quot;&quot;</STRING>
        </VAR>
        <VAR name = "Model">
            <VAR name = "Radar_Cross_Section">
                <SCOPE Class = "RCS">
                    <VAR name = "Version">
                        <STRING>&quot;1.0.0 a&quot;</STRING>
                    </VAR>
                    <VAR name = "ComponentName">
                        <STRING>&quot;Radar_Cross_Section&quot;</STRING>
                    </VAR>
                    <VAR name = "Description">
                        <STRING>&quot;Radar Cross Section&quot;</STRING>
                    </VAR>
                    <VAR name = "Type">
                        <STRING>&quot;Radar Cross Section&quot;</STRING>
                    </VAR>
                    <VAR name = "UserComment">
                        <STRING>&quot;Radar Cross Section&quot;</STRING>
                    </VAR>
                    <VAR name = "ReadOnly">
                        <BOOL>false</BOOL>
                    </VAR>
                    <VAR name = "Clonable">
                        <BOOL>true</BOOL>
                    </VAR>
                    <VAR name = "Category">
                        <STRING>&quot;&quot;</STRING>
                    </VAR>
                    <VAR name = "FrequencyBandList">
                        <LIST>
                            <SCOPE>
                                <VAR name = "MinFrequency">
                                    <QUANTITY Dimension = "BandwidthUnit" Unit = "Hz">
                                        <REAL>2997920</REAL>
                                    </QUANTITY>
                                </VAR>
                                <VAR name = "ComputeTypeStrategy">
                                    <VAR name = "Constant Value">
                                        <SCOPE Class = "RCS Compute Strategy">
                                            <VAR name = "ConstantValue">
                                                <QUANTITY Dimension = "RcsUnit" Unit = "sqm">
                                                    <REAL>1</REAL>
                                                </QUANTITY>
                                            </VAR>
                                            <VAR name = "Type">
                                                <STRING>&quot;Constant Value&quot;</STRING>
                                            </VAR>
                                            <VAR name = "ComponentName">
                                                <STRING>&quot;Constant Value&quot;</STRING>
                                            </VAR>
                                        </SCOPE>
                                    </VAR>
                                </VAR>
                                <VAR name = "SwerlingCase">
                                    <STRING>&quot;0&quot;</STRING>
                                </VAR>
                            </SCOPE>
                        </LIST>
                    </VAR>
                </SCOPE>
            </VAR>
        </VAR>
    </SCOPE>
</VAR>    END RadarCrossSection
    
    BEGIN RadarClutter
<?xml version = "1.0" standalone = "yes"?>
<VAR name = "STK_Radar_Clutter_Extension">
    <SCOPE Class = "RadarClutterExtension">
        <VAR name = "Version">
            <STRING>&quot;1.0.0 a&quot;</STRING>
        </VAR>
        <VAR name = "ComponentName">
            <STRING>&quot;STK_Radar_Clutter_Extension&quot;</STRING>
        </VAR>
        <VAR name = "Description">
            <STRING>&quot;STK Radar Clutter Extension&quot;</STRING>
        </VAR>
        <VAR name = "Type">
            <STRING>&quot;STK Radar Clutter Extension&quot;</STRING>
        </VAR>
        <VAR name = "UserComment">
            <STRING>&quot;STK Radar Clutter Extension&quot;</STRING>
        </VAR>
        <VAR name = "ReadOnly">
            <BOOL>false</BOOL>
        </VAR>
        <VAR name = "Clonable">
            <BOOL>true</BOOL>
        </VAR>
        <VAR name = "Category">
            <STRING>&quot;&quot;</STRING>
        </VAR>
        <VAR name = "ClutterMap">
            <VAR name = "Constant Coefficient">
                <SCOPE Class = "Clutter Map">
                    <VAR name = "ClutterCoefficient">
                        <QUANTITY Dimension = "RatioUnit" Unit = "units">
                            <REAL>1</REAL>
                        </QUANTITY>
                    </VAR>
                    <VAR name = "Type">
                        <STRING>&quot;Constant Coefficient&quot;</STRING>
                    </VAR>
                    <VAR name = "ComponentName">
                        <STRING>&quot;Constant Coefficient&quot;</STRING>
                    </VAR>
                </SCOPE>
            </VAR>
        </VAR>
    </SCOPE>
</VAR>    END RadarClutter
    
    BEGIN Gator
    END Gator
    
    BEGIN Crdn
    END Crdn
    
    BEGIN ScenSpaceEnvironment

        Begin RadiationEnvironment

           NasaModelsActivity      SolarMin
           CrresProActivity        Quiet
           CrresRadActivity        Average
           UseDefaultNasaEnergies  Yes

        End RadiationEnvironment

    END ScenSpaceEnvironment
    
    BEGIN SpiceExt
    END SpiceExt
    
    BEGIN FlightScenExt
    END FlightScenExt
    
    BEGIN Graphics

BEGIN Animation

    StartTime          5 Jan 2022 11:00:00.000000000
    EndTime            6 Jan 2022 11:00:00.000000000
    CurrentTime        5 Jan 2022 11:00:00.000000000
    Direction          Forward
    UpdateDelta        10.000000
    RefreshDelta       0.010000
    XRealTimeMult      1.000000
    RealTimeOffset     0.000000
    XRtStartFromPause  Yes

END Animation


        BEGIN DisplayFlags
            ShowLabels           On
            ShowPassLabel        Off
            ShowElsetNum         Off
            ShowGndTracks        On
            ShowGndMarkers       On
            ShowOrbitMarkers     On
            ShowPlanetOrbits     Off
            ShowPlanetCBIPos     On
            ShowPlanetCBILabel   On
            ShowPlanetGndPos     On
            ShowPlanetGndLabel   On
            ShowSensors          On
            ShowWayptMarkers     Off
            ShowWayptTurnMarkers Off
            ShowOrbits           On
            ShowDtedRegions      Off
            ShowAreaTgtCentroids On
            ShowToolBar          On
            ShowStatusBar        On
            ShowScrollBars       On
            AllowAnimUpdate      On
            AccShowLine          On
            AccAnimHigh          On
            AccStatHigh          On
            ShowPrintButton      On
            ShowAnimButtons      On
            ShowAnimModeButtons  On
            ShowZoomMsrButtons   On
            ShowMapCbButton      Off
        END DisplayFlags

BEGIN WinFonts

    System
    MS Sans Serif,22,0,0
    MS Sans Serif,28,0,0

END WinFonts

BEGIN MapData

    Begin TerrainConverterData
           NorthLat        0.00000000000000e+00
           EastLon         0.00000000000000e+00
           SouthLat        0.00000000000000e+00
           WestLon         0.00000000000000e+00
           ColorByRGB      No
           AltsFromMSL     No
           UseColorRamp    Yes
           UseRegionMinMax Yes
           SizeSameAsSrc   Yes
           MinAltHSV       0.00000000000000e+00 7.00000000000000e-01 8.00000000000000e-01 4.00000000000000e-01
           MaxAltHSV       1.00000000000000e+06 0.00000000000000e+00 2.00000000000000e-01 1.00000000000000e+00
           SmoothColors    Yes
           CreateChunkTrn  No
           OutputFormat    PDTTX
    End TerrainConverterData

    DisableDefKbdActions     Off
    TextShadowStyle          Dark
    TextShadowColor          #000000
    BingLevelOfDetailScale   2.000000
    BEGIN Map
        MapNum         1
        TrackingMode   LatLon
        PickEnabled    On
        PanEnabled     On

        BEGIN MapAttributes
            PrimaryBody          Earth
            SecondaryBody        Sun
            CenterLatitude       0.000000
            CenterLongitude      0.000000
            ProjectionAltitude   63621860.000000
            FieldOfView          35.000000
            OrthoDisplayDistance 20000000.000000
            TransformTrajectory  On
            EquatorialRadius     6378137.000000
            BackgroundColor      #000000
            LatLonLines          On
            LatSpacing           30.000000
            LonSpacing           30.000000
            LatLonLineColor      #999999
            LatLonLineStyle      2
            ShowOrthoDistGrid    Off
            OrthoGridXSpacing    5
            OrthoGridYSpacing    5
            OrthoGridColor       #ffffff
            ShowImageExtents     Off
            ImageExtentLineColor #ffffff
            ImageExtentLineStyle 0
            ImageExtentLineWidth 1.000000
            ShowImageNames       Off
            ImageNameFont        0
            Projection           EquidistantCylindrical
            Resolution           VeryLow
            CoordinateSys        ECF
            UseBackgroundImage   On
            UseBingForBackground Off
            BingType             Aerial
            BingLogoHorizAlign   Right
            BingLogoVertAlign    Bottom
            BackgroundImageFile  Basic.bmp
            UseNightLights       Off
            NightLightsFactor    3.500000
            UseCloudsFile        Off
            BEGIN ZoomLocations
                BEGIN ZoomLocation
                    CenterLat    0.000000
                    CenterLon    0.000000
                    ZoomWidth    359.999998
                    ZoomHeight   180.000000
                End ZoomLocation
            END ZoomLocations
            UseVarAspectRatio    No
            SwapMapResolution    Yes
            NoneToVLowSwapDist   2000000.000000
            VLowToLowSwapDist    20000.000000
            LowToMediumSwapDist  10000.000000
            MediumToHighSwapDist 5000.000000
            HighToVHighSwapDist  1000.000000
            VHighToSHighSwapDist 100.000000
            BEGIN Axes
                DisplayAxes no
                CoordSys    CBI
                2aryCB      Sun
                Display+x   yes
                Label+x     yes
                Color+x     #ffffff
                Scale+x     3.000000
                Display-x   yes
                Label-x     yes
                Color-x     #ffffff
                Scale-x     3.000000
                Display+y   yes
                Label+y     yes
                Color+y     #ffffff
                Scale+y     3.000000
                Display-y   yes
                Label-y     yes
                Color-y     #ffffff
                Scale-y     3.000000
                Display+z   yes
                Label+z     yes
                Color+z     #ffffff
                Scale+z     3.000000
                Display-z   yes
                Label-z     yes
                Color-z     #ffffff
                Scale-z     3.000000
            END Axes

        END MapAttributes

        BEGIN MapList
            BEGIN Detail
                Alias RWDB2_Coastlines
                Show Yes
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_International_Borders
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Islands
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Lakes
                Show No
                Color #87cefa
            END Detail
            BEGIN Detail
                Alias RWDB2_Provincial_Borders
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Rivers
                Show No
                Color #87cefa
            END Detail
        END MapList


        BEGIN MapAnnotations
        END MapAnnotations

        BEGIN DisplayFlags
            ShowLabels           On
            ShowPassLabel        Off
            ShowElsetNum         Off
            ShowGndTracks        On
            ShowGndMarkers       On
            ShowOrbitMarkers     On
            ShowPlanetOrbits     Off
            ShowPlanetCBIPos     On
            ShowPlanetCBILabel   On
            ShowPlanetGndPos     On
            ShowPlanetGndLabel   On
            ShowSensors          On
            ShowWayptMarkers     Off
            ShowWayptTurnMarkers Off
            ShowOrbits           On
            ShowDtedRegions      Off
            ShowAreaTgtCentroids On
            ShowToolBar          On
            ShowStatusBar        On
            ShowScrollBars       On
            AllowAnimUpdate      Off
            AccShowLine          On
            AccAnimHigh          On
            AccStatHigh          On
            ShowPrintButton      On
            ShowAnimButtons      On
            ShowAnimModeButtons  On
            ShowZoomMsrButtons   On
            ShowMapCbButton      Off
        END DisplayFlags

        BEGIN SoftVTR
            OutputFormat     WMV
            Directory        C:\Users\Carla\Documents\STK 11 (x64)\Scenario1
            BaseName         Frame
            Digits           4
            Frame            0
            LastAnimTime     0.000000
            OutputMode       Normal
            HiResAssembly    Assemble
            HRWidth          6000
            HRHeight         4500
            HRDPI            600.000000
            UseSnapInterval  No
            SnapInterval     0.000000
            WmvCodec         "Windows Media Video 9"
            Framerate        30
            Bitrate          3000000
        END SoftVTR


        BEGIN TimeDisplay
            Show             0
            TextColor        #ffffff
            TextTranslucency 0.000000
            ShowBackground   0
            BackColor        #4d4d4d
            BackTranslucency 0.400000
            XPosition        20
            YPosition        -20
        END TimeDisplay

        BEGIN LightingData
            DisplayAltitude              0.000000
            SubsolarPoint                Off
            SubsolarPointColor           #ffff00
            SubsolarPointMarkerStyle     2

            ShowUmbraLine                Off
            UmbraLineColor               #000000
            UmbraLineStyle               0
            UmbraLineWidth               2
            FillUmbra                    On
            UmbraFillColor               #000000
            ShowSunlightLine             Off
            SunlightLineColor            #ffff00
            SunlightLineStyle            0
            SunlightLineWidth            2
            FillSunlight                 On
            SunlightFillColor            #ffffff
            SunlightMinOpacity           0.000000
            SunlightMaxOpacity           0.200000
            UmbraMaxOpacity              0.700000
            UmbraMinOpacity              0.400000
        END LightingData
    END Map

    BEGIN MapStyles

        UseStyleTime        No

        BEGIN Style
        Name                DefaultWithBing
        Time                0.000000
        UpdateDelta         10.000000

        BEGIN MapAttributes
            PrimaryBody          Earth
            SecondaryBody        Sun
            CenterLatitude       0.000000
            CenterLongitude      0.000000
            ProjectionAltitude   63621860.000000
            FieldOfView          35.000000
            OrthoDisplayDistance 20000000.000000
            TransformTrajectory  On
            EquatorialRadius     6378137.000000
            BackgroundColor      #000000
            LatLonLines          On
            LatSpacing           30.000000
            LonSpacing           30.000000
            LatLonLineColor      #999999
            LatLonLineStyle      2
            ShowOrthoDistGrid    Off
            OrthoGridXSpacing    5
            OrthoGridYSpacing    5
            OrthoGridColor       #ffffff
            ShowImageExtents     Off
            ImageExtentLineColor #ffffff
            ImageExtentLineStyle 0
            ImageExtentLineWidth 1.000000
            ShowImageNames       Off
            ImageNameFont        0
            Projection           EquidistantCylindrical
            Resolution           VeryLow
            CoordinateSys        ECF
            UseBackgroundImage   On
            UseBingForBackground Off
            BingType             Aerial
            BingLogoHorizAlign   Right
            BingLogoVertAlign    Bottom
            BackgroundImageFile  Basic.bmp
            UseNightLights       Off
            NightLightsFactor    3.500000
            UseCloudsFile        Off
            BEGIN ZoomLocations
                BEGIN ZoomLocation
                    CenterLat    0.000000
                    CenterLon    0.000000
                    ZoomWidth    359.999998
                    ZoomHeight   180.000000
                End ZoomLocation
            END ZoomLocations
            UseVarAspectRatio    No
            SwapMapResolution    Yes
            NoneToVLowSwapDist   2000000.000000
            VLowToLowSwapDist    20000.000000
            LowToMediumSwapDist  10000.000000
            MediumToHighSwapDist 5000.000000
            HighToVHighSwapDist  1000.000000
            VHighToSHighSwapDist 100.000000
            BEGIN Axes
                DisplayAxes no
                CoordSys    CBI
                2aryCB      Sun
                Display+x   yes
                Label+x     yes
                Color+x     #ffffff
                Scale+x     3.000000
                Display-x   yes
                Label-x     yes
                Color-x     #ffffff
                Scale-x     3.000000
                Display+y   yes
                Label+y     yes
                Color+y     #ffffff
                Scale+y     3.000000
                Display-y   yes
                Label-y     yes
                Color-y     #ffffff
                Scale-y     3.000000
                Display+z   yes
                Label+z     yes
                Color+z     #ffffff
                Scale+z     3.000000
                Display-z   yes
                Label-z     yes
                Color-z     #ffffff
                Scale-z     3.000000
            END Axes

        END MapAttributes

        BEGIN MapList
            BEGIN Detail
                Alias RWDB2_Coastlines
                Show Yes
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_International_Borders
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Islands
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Lakes
                Show No
                Color #87cefa
            END Detail
            BEGIN Detail
                Alias RWDB2_Provincial_Borders
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Rivers
                Show No
                Color #87cefa
            END Detail
        END MapList


        BEGIN MapAnnotations
        END MapAnnotations

        BEGIN SoftVTR
            OutputFormat     WMV
            Directory        C:\Users\Carla\Documents\STK 11 (x64)\Scenario1
            BaseName         Frame
            Digits           4
            Frame            0
            LastAnimTime     0.000000
            OutputMode       Normal
            HiResAssembly    Assemble
            HRWidth          6000
            HRHeight         4500
            HRDPI            600.000000
            UseSnapInterval  No
            SnapInterval     0.000000
            WmvCodec         "Windows Media Video 9"
            Framerate        30
            Bitrate          3000000
        END SoftVTR


        BEGIN TimeDisplay
            Show             0
            TextColor        #ffffff
            TextTranslucency 0.000000
            ShowBackground   0
            BackColor        #4d4d4d
            BackTranslucency 0.400000
            XPosition        20
            YPosition        -20
        END TimeDisplay

        BEGIN LightingData
            DisplayAltitude              0.000000
            SubsolarPoint                Off
            SubsolarPointColor           #ffff00
            SubsolarPointMarkerStyle     2

            ShowUmbraLine                Off
            UmbraLineColor               #000000
            UmbraLineStyle               0
            UmbraLineWidth               2
            FillUmbra                    On
            UmbraFillColor               #000000
            ShowSunlightLine             Off
            SunlightLineColor            #ffff00
            SunlightLineStyle            0
            SunlightLineWidth            2
            FillSunlight                 On
            SunlightFillColor            #ffffff
            SunlightMinOpacity           0.000000
            SunlightMaxOpacity           0.200000
            UmbraMaxOpacity              0.700000
            UmbraMinOpacity              0.400000
        END LightingData

        ShowDtedRegions     Off

        End Style

        BEGIN Style
        Name                DefaultWithoutBing
        Time                0.000000
        UpdateDelta         10.000000

        BEGIN MapAttributes
            PrimaryBody          Earth
            SecondaryBody        Sun
            CenterLatitude       0.000000
            CenterLongitude      0.000000
            ProjectionAltitude   63621860.000000
            FieldOfView          35.000000
            OrthoDisplayDistance 20000000.000000
            TransformTrajectory  On
            EquatorialRadius     6378137.000000
            BackgroundColor      #000000
            LatLonLines          On
            LatSpacing           30.000000
            LonSpacing           30.000000
            LatLonLineColor      #999999
            LatLonLineStyle      2
            ShowOrthoDistGrid    Off
            OrthoGridXSpacing    5
            OrthoGridYSpacing    5
            OrthoGridColor       #ffffff
            ShowImageExtents     Off
            ImageExtentLineColor #ffffff
            ImageExtentLineStyle 0
            ImageExtentLineWidth 1.000000
            ShowImageNames       Off
            ImageNameFont        0
            Projection           EquidistantCylindrical
            Resolution           VeryLow
            CoordinateSys        ECF
            UseBackgroundImage   On
            UseBingForBackground Off
            BingType             Aerial
            BingLogoHorizAlign   Right
            BingLogoVertAlign    Bottom
            BackgroundImageFile  Basic.bmp
            UseNightLights       Off
            NightLightsFactor    3.500000
            UseCloudsFile        Off
            BEGIN ZoomLocations
                BEGIN ZoomLocation
                    CenterLat    0.000000
                    CenterLon    0.000000
                    ZoomWidth    359.999998
                    ZoomHeight   180.000000
                End ZoomLocation
            END ZoomLocations
            UseVarAspectRatio    No
            SwapMapResolution    Yes
            NoneToVLowSwapDist   2000000.000000
            VLowToLowSwapDist    20000.000000
            LowToMediumSwapDist  10000.000000
            MediumToHighSwapDist 5000.000000
            HighToVHighSwapDist  1000.000000
            VHighToSHighSwapDist 100.000000
            BEGIN Axes
                DisplayAxes no
                CoordSys    CBI
                2aryCB      Sun
                Display+x   yes
                Label+x     yes
                Color+x     #ffffff
                Scale+x     3.000000
                Display-x   yes
                Label-x     yes
                Color-x     #ffffff
                Scale-x     3.000000
                Display+y   yes
                Label+y     yes
                Color+y     #ffffff
                Scale+y     3.000000
                Display-y   yes
                Label-y     yes
                Color-y     #ffffff
                Scale-y     3.000000
                Display+z   yes
                Label+z     yes
                Color+z     #ffffff
                Scale+z     3.000000
                Display-z   yes
                Label-z     yes
                Color-z     #ffffff
                Scale-z     3.000000
            END Axes

        END MapAttributes

        BEGIN MapList
            BEGIN Detail
                Alias RWDB2_Coastlines
                Show Yes
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_International_Borders
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Islands
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Lakes
                Show No
                Color #87cefa
            END Detail
            BEGIN Detail
                Alias RWDB2_Provincial_Borders
                Show No
                Color #8fbc8f
            END Detail
            BEGIN Detail
                Alias RWDB2_Rivers
                Show No
                Color #87cefa
            END Detail
        END MapList


        BEGIN MapAnnotations
        END MapAnnotations

        BEGIN SoftVTR
            OutputFormat     WMV
            Directory        C:\Users\Carla\Documents\STK 11 (x64)\Scenario1
            BaseName         Frame
            Digits           4
            Frame            0
            LastAnimTime     0.000000
            OutputMode       Normal
            HiResAssembly    Assemble
            HRWidth          6000
            HRHeight         4500
            HRDPI            600.000000
            UseSnapInterval  No
            SnapInterval     0.000000
            WmvCodec         "Windows Media Video 9"
            Framerate        30
            Bitrate          3000000
        END SoftVTR


        BEGIN TimeDisplay
            Show             0
            TextColor        #ffffff
            TextTranslucency 0.000000
            ShowBackground   0
            BackColor        #4d4d4d
            BackTranslucency 0.400000
            XPosition        20
            YPosition        -20
        END TimeDisplay

        BEGIN LightingData
            DisplayAltitude              0.000000
            SubsolarPoint                Off
            SubsolarPointColor           #ffff00
            SubsolarPointMarkerStyle     2

            ShowUmbraLine                Off
            UmbraLineColor               #000000
            UmbraLineStyle               0
            UmbraLineWidth               2
            FillUmbra                    On
            UmbraFillColor               #000000
            ShowSunlightLine             Off
            SunlightLineColor            #ffff00
            SunlightLineStyle            0
            SunlightLineWidth            2
            FillSunlight                 On
            SunlightFillColor            #ffffff
            SunlightMinOpacity           0.000000
            SunlightMaxOpacity           0.200000
            UmbraMaxOpacity              0.700000
            UmbraMinOpacity              0.400000
        END LightingData

        ShowDtedRegions     Off

        End Style

    END MapStyles

END MapData

        BEGIN GfxClassPref

        END GfxClassPref


        BEGIN ConnectGraphicsOptions

            AsyncPickReturnUnique          OFF

        END ConnectGraphicsOptions

    END Graphics
    
    BEGIN Overlays
    END Overlays
    
    BEGIN VO
    END VO
    
    BEGIN ScenSpaceEnvironmentGfx

        Begin Gfx

           Begin MagFieldGfx
               Show               No
               ColorBy            Magnitude
               ColorScale         Log
               ColorRampStart     #0000ff
               ColorRampStart     #0000ff
               ColorRampStop      #ff0000
               MaxTranslucency    0.700000
               LineStyle          0
               LineWidth          2.000000
               FieldLineRefresh   300.000000
               NumLats            8
               NumLongs           6
               StartLat           15.000000
               StopLat            85.000000
               RefLongitude       3.141593
               MainField          IGRF
               ExternalField      None
               IGRF_UpdateRate    86400.000000
           End MagFieldGfx

        End Gfx

    END ScenSpaceEnvironmentGfx
    
    BEGIN DIS

		Begin General

			Verbose                    Off
			Processing                 Off
			Statistics                 Off
			ExerciseID                 -1
			ForceID                    -1

		End General


		Begin Output

			Version                    5
			ExerciseID                 1
			forceID                    1
			HeartbeatTimer             5.000000
			DistanceThresh             1.000000
			OrientThresh               3.000000

		End Output


		Begin Time

			Mode                       rtPDUTimestamp

		End Time


		Begin PDUInfo


		End PDUInfo


		Begin Parameters

			ParmData  COLORFRIENDLY        blue
			ParmData  COLORNEUTRAL         white
			ParmData  COLOROPFORCE         red
			ParmData  MAXDRELSETS          1000

		End Parameters


		Begin Network

			NetIF                      Default
			Mode                       Broadcast
			McastIP                    224.0.0.1
			Port                       3000
			rChannelBufferSize         65000
			ReadBufferSize             1500
			QueuePollPeriod            20
			MaxRcvQueueEntries         1000
			MaxRcvIOThreads            4
			sChannelBufferSize         65000

		End Network


		Begin EntityTypeDef


#			order: kind:domain:country:catagory:subCatagory:specific:xtra ( -1 = * )


		End EntityTypeDef


		Begin EntityFilter
			Include                    *:*:*
		End EntityFilter

    END DIS

END Extensions

BEGIN SubObjects

Class Constellation

	AllUsers

END Class

Class Satellite

	AAUSAT_4_41460
	BIRD_2_26959
	CHUANGXIN_1-03_37930
	CHUANGXIN_1-04_40137
	DEIMOS-1_35681
	DLR-TUBSAT_25757
	GHGSAT-D_41602
	INS-1A_41949
	INS-1B_41954
	LAPAN-TUBSAT_29709
	LQSAT_40958
	M3MSAT_41605
	NIGERIASAT-X_37790
	PATHFINDER_1_41787
	QSAT-EOS_40301
	RISING_2_39769
	SAUDISAT_2_28371
	SPARK_1_41900
	SPARK_2_41901
	TIANTUO_2_40144
	TIGRISAT_40043
	tle-42792_42792
	tle-42793_42793
	tle-42826_42826
	tle-42828_42828
	tle-42835_42835
	tle-42846_42846
	tle-42847_42847
	tle-42848_42848
	tle-42849_42849
	tle-43011_43011
	tle-43118_43118
	tle-43131_43131
	tle-43143_43143
	tle-43197_43197
	tle-43439_43439
	tle-43440_43440
	tle-43441_43441
	tle-43442_43442
	tle-43443_43443
	tle-43485_43485
	tle-43678_43678
	tle-43721_43721
	tle-43730_43730
	tle-43737_43737
	tle-43743_43743
	tle-43765_43765
	tle-43767_43767
	tle-43768_43768
	tle-43783_43783
	tle-43790_43790
	tle-43791_43791
	tle-43792_43792
	tle-43794_43794
	tle-43799_43799
	tle-43800_43800
	tle-43812_43812
	tle-43820_43820
	tle-43822_43822
	tle-43890_43890
	tle-43907_43907
	tle-43934_43934
	tle-43935_43935
	tle-43942_43942
	tle-44103_44103
	tle-44389_44389
	tle-44390_44390
	tle-44486_44486
	tle-44488_44488
	tle-44529_44529
	tle-44534_44534
	tle-44536_44536
	tle-44537_44537
	tle-44538_44538
	tle-44539_44539
	tle-44703_44703
	tle-44704_44704
	tle-44824_44824
	tle-44838_44838
	tle-44839_44839
	tle-44879_44879
	tle-44880_44880
	tle-45624_45624
	tle-45796_45796
	tle-46266_46266
	tle-46277_46277
	tle-46278_46278
	tle-46279_46279
	tle-46292_46292
	tle-46293_46293
	tle-46312_46312
	tle-46320_46320
	tle-46489_46489
	tle-46496_46496
	tle-46497_46497
	tle-46931_46931
	tle-47300_47300
	tle-47441_47441
	tle-47485_47485
	tle-47502_47502
	tle-47505_47505
	tle-47506_47506
	tle-47507_47507
	tle-47508_47508
	tle-47509_47509
	tle-47510_47510
	tle-47933_47933
	tle-47934_47934
	tle-47935_47935
	tle-47936_47936
	tle-47940_47940
	tle-47953_47953
	tle-48248_48248
	tle-48249_48249
	tle-48254_48254
	tle-48255_48255
	tle-48272_48272
	tle-48901_48901
	tle-48906_48906
	tle-48910_48910
	tle-48914_48914
	tle-48916_48916
	tle-48917_48917
	tle-48918_48918
	tle-48922_48922
	tle-48926_48926
	tle-48928_48928
	tle-48930_48930
	tle-48931_48931
	tle-48942_48942
	tle-48948_48948
	tle-48950_48950
	tle-48953_48953
	tle-48957_48957
	tle-48962_48962
	tle-48963_48963
	tle-48965_48965
	tle-49007_49007
	tle-49066_49066
	UK-DMC_2_35683
	UNIFORM_1_39767
	WNISAT-1_39423
	X-SAT_37389
	YIJIAN_41899

END Class

END SubObjects

BEGIN References
    Instance *
        *
        Constellation/AllUsers
    END Instance
    Instance Constellation/AllUsers
    END Instance
    Instance Satellite/AAUSAT_4_41460
        Constellation/AllUsers
        Satellite/AAUSAT_4_41460
    END Instance
    Instance Satellite/BIRD_2_26959
        Constellation/AllUsers
        Satellite/BIRD_2_26959
    END Instance
    Instance Satellite/CHUANGXIN_1-03_37930
        Constellation/AllUsers
        Satellite/CHUANGXIN_1-03_37930
    END Instance
    Instance Satellite/CHUANGXIN_1-04_40137
        Constellation/AllUsers
        Satellite/CHUANGXIN_1-04_40137
    END Instance
    Instance Satellite/DEIMOS-1_35681
        Constellation/AllUsers
        Satellite/DEIMOS-1_35681
    END Instance
    Instance Satellite/DLR-TUBSAT_25757
        Constellation/AllUsers
        Satellite/DLR-TUBSAT_25757
    END Instance
    Instance Satellite/GHGSAT-D_41602
        Constellation/AllUsers
        Satellite/GHGSAT-D_41602
    END Instance
    Instance Satellite/INS-1A_41949
        Constellation/AllUsers
        Satellite/INS-1A_41949
    END Instance
    Instance Satellite/INS-1B_41954
        Constellation/AllUsers
        Satellite/INS-1B_41954
    END Instance
    Instance Satellite/LAPAN-TUBSAT_29709
        Constellation/AllUsers
        Satellite/LAPAN-TUBSAT_29709
    END Instance
    Instance Satellite/LQSAT_40958
        Constellation/AllUsers
        Satellite/LQSAT_40958
    END Instance
    Instance Satellite/M3MSAT_41605
        Constellation/AllUsers
        Satellite/M3MSAT_41605
    END Instance
    Instance Satellite/NIGERIASAT-X_37790
        Constellation/AllUsers
        Satellite/NIGERIASAT-X_37790
    END Instance
    Instance Satellite/PATHFINDER_1_41787
        Constellation/AllUsers
        Satellite/PATHFINDER_1_41787
    END Instance
    Instance Satellite/QSAT-EOS_40301
        Constellation/AllUsers
        Satellite/QSAT-EOS_40301
    END Instance
    Instance Satellite/RISING_2_39769
        Constellation/AllUsers
        Satellite/RISING_2_39769
    END Instance
    Instance Satellite/SAUDISAT_2_28371
        Constellation/AllUsers
        Satellite/SAUDISAT_2_28371
    END Instance
    Instance Satellite/SPARK_1_41900
        Constellation/AllUsers
        Satellite/SPARK_1_41900
    END Instance
    Instance Satellite/SPARK_2_41901
        Constellation/AllUsers
        Satellite/SPARK_2_41901
    END Instance
    Instance Satellite/TIANTUO_2_40144
        Constellation/AllUsers
        Satellite/TIANTUO_2_40144
    END Instance
    Instance Satellite/TIGRISAT_40043
        Constellation/AllUsers
        Satellite/TIGRISAT_40043
    END Instance
    Instance Satellite/UK-DMC_2_35683
        Constellation/AllUsers
        Satellite/UK-DMC_2_35683
    END Instance
    Instance Satellite/UNIFORM_1_39767
        Constellation/AllUsers
        Satellite/UNIFORM_1_39767
    END Instance
    Instance Satellite/WNISAT-1_39423
        Constellation/AllUsers
        Satellite/WNISAT-1_39423
    END Instance
    Instance Satellite/X-SAT_37389
        Constellation/AllUsers
        Satellite/X-SAT_37389
    END Instance
    Instance Satellite/YIJIAN_41899
        Constellation/AllUsers
        Satellite/YIJIAN_41899
    END Instance
    Instance Satellite/tle-42792_42792
        Constellation/AllUsers
        Satellite/tle-42792_42792
    END Instance
    Instance Satellite/tle-42793_42793
        Constellation/AllUsers
        Satellite/tle-42793_42793
    END Instance
    Instance Satellite/tle-42826_42826
        Constellation/AllUsers
        Satellite/tle-42826_42826
    END Instance
    Instance Satellite/tle-42828_42828
        Constellation/AllUsers
        Satellite/tle-42828_42828
    END Instance
    Instance Satellite/tle-42835_42835
        Constellation/AllUsers
        Satellite/tle-42835_42835
    END Instance
    Instance Satellite/tle-42846_42846
        Constellation/AllUsers
        Satellite/tle-42846_42846
    END Instance
    Instance Satellite/tle-42847_42847
        Constellation/AllUsers
        Satellite/tle-42847_42847
    END Instance
    Instance Satellite/tle-42848_42848
        Constellation/AllUsers
        Satellite/tle-42848_42848
    END Instance
    Instance Satellite/tle-42849_42849
        Constellation/AllUsers
        Satellite/tle-42849_42849
    END Instance
    Instance Satellite/tle-43011_43011
        Constellation/AllUsers
        Satellite/tle-43011_43011
    END Instance
    Instance Satellite/tle-43118_43118
        Constellation/AllUsers
        Satellite/tle-43118_43118
    END Instance
    Instance Satellite/tle-43131_43131
        Constellation/AllUsers
        Satellite/tle-43131_43131
    END Instance
    Instance Satellite/tle-43143_43143
        Constellation/AllUsers
        Satellite/tle-43143_43143
    END Instance
    Instance Satellite/tle-43197_43197
        Constellation/AllUsers
        Satellite/tle-43197_43197
    END Instance
    Instance Satellite/tle-43439_43439
        Constellation/AllUsers
        Satellite/tle-43439_43439
    END Instance
    Instance Satellite/tle-43440_43440
        Constellation/AllUsers
        Satellite/tle-43440_43440
    END Instance
    Instance Satellite/tle-43441_43441
        Constellation/AllUsers
        Satellite/tle-43441_43441
    END Instance
    Instance Satellite/tle-43442_43442
        Constellation/AllUsers
        Satellite/tle-43442_43442
    END Instance
    Instance Satellite/tle-43443_43443
        Constellation/AllUsers
        Satellite/tle-43443_43443
    END Instance
    Instance Satellite/tle-43485_43485
        Constellation/AllUsers
        Satellite/tle-43485_43485
    END Instance
    Instance Satellite/tle-43678_43678
        Constellation/AllUsers
        Satellite/tle-43678_43678
    END Instance
    Instance Satellite/tle-43721_43721
        Constellation/AllUsers
        Satellite/tle-43721_43721
    END Instance
    Instance Satellite/tle-43730_43730
        Constellation/AllUsers
        Satellite/tle-43730_43730
    END Instance
    Instance Satellite/tle-43737_43737
        Constellation/AllUsers
        Satellite/tle-43737_43737
    END Instance
    Instance Satellite/tle-43743_43743
        Constellation/AllUsers
        Satellite/tle-43743_43743
    END Instance
    Instance Satellite/tle-43765_43765
        Constellation/AllUsers
        Satellite/tle-43765_43765
    END Instance
    Instance Satellite/tle-43767_43767
        Constellation/AllUsers
        Satellite/tle-43767_43767
    END Instance
    Instance Satellite/tle-43768_43768
        Constellation/AllUsers
        Satellite/tle-43768_43768
    END Instance
    Instance Satellite/tle-43783_43783
        Constellation/AllUsers
        Satellite/tle-43783_43783
    END Instance
    Instance Satellite/tle-43790_43790
        Constellation/AllUsers
        Satellite/tle-43790_43790
    END Instance
    Instance Satellite/tle-43791_43791
        Constellation/AllUsers
        Satellite/tle-43791_43791
    END Instance
    Instance Satellite/tle-43792_43792
        Constellation/AllUsers
        Satellite/tle-43792_43792
    END Instance
    Instance Satellite/tle-43794_43794
        Constellation/AllUsers
        Satellite/tle-43794_43794
    END Instance
    Instance Satellite/tle-43799_43799
        Constellation/AllUsers
        Satellite/tle-43799_43799
    END Instance
    Instance Satellite/tle-43800_43800
        Constellation/AllUsers
        Satellite/tle-43800_43800
    END Instance
    Instance Satellite/tle-43812_43812
        Constellation/AllUsers
        Satellite/tle-43812_43812
    END Instance
    Instance Satellite/tle-43820_43820
        Constellation/AllUsers
        Satellite/tle-43820_43820
    END Instance
    Instance Satellite/tle-43822_43822
        Constellation/AllUsers
        Satellite/tle-43822_43822
    END Instance
    Instance Satellite/tle-43890_43890
        Constellation/AllUsers
        Satellite/tle-43890_43890
    END Instance
    Instance Satellite/tle-43907_43907
        Constellation/AllUsers
        Satellite/tle-43907_43907
    END Instance
    Instance Satellite/tle-43934_43934
        Constellation/AllUsers
        Satellite/tle-43934_43934
    END Instance
    Instance Satellite/tle-43935_43935
        Constellation/AllUsers
        Satellite/tle-43935_43935
    END Instance
    Instance Satellite/tle-43942_43942
        Constellation/AllUsers
        Satellite/tle-43942_43942
    END Instance
    Instance Satellite/tle-44103_44103
        Constellation/AllUsers
        Satellite/tle-44103_44103
    END Instance
    Instance Satellite/tle-44389_44389
        Constellation/AllUsers
        Satellite/tle-44389_44389
    END Instance
    Instance Satellite/tle-44390_44390
        Constellation/AllUsers
        Satellite/tle-44390_44390
    END Instance
    Instance Satellite/tle-44486_44486
        Constellation/AllUsers
        Satellite/tle-44486_44486
    END Instance
    Instance Satellite/tle-44488_44488
        Constellation/AllUsers
        Satellite/tle-44488_44488
    END Instance
    Instance Satellite/tle-44529_44529
        Constellation/AllUsers
        Satellite/tle-44529_44529
    END Instance
    Instance Satellite/tle-44534_44534
        Constellation/AllUsers
        Satellite/tle-44534_44534
    END Instance
    Instance Satellite/tle-44536_44536
        Constellation/AllUsers
        Satellite/tle-44536_44536
    END Instance
    Instance Satellite/tle-44537_44537
        Constellation/AllUsers
        Satellite/tle-44537_44537
    END Instance
    Instance Satellite/tle-44538_44538
        Constellation/AllUsers
        Satellite/tle-44538_44538
    END Instance
    Instance Satellite/tle-44539_44539
        Constellation/AllUsers
        Satellite/tle-44539_44539
    END Instance
    Instance Satellite/tle-44703_44703
        Constellation/AllUsers
        Satellite/tle-44703_44703
    END Instance
    Instance Satellite/tle-44704_44704
        Constellation/AllUsers
        Satellite/tle-44704_44704
    END Instance
    Instance Satellite/tle-44824_44824
        Constellation/AllUsers
        Satellite/tle-44824_44824
    END Instance
    Instance Satellite/tle-44838_44838
        Constellation/AllUsers
        Satellite/tle-44838_44838
    END Instance
    Instance Satellite/tle-44839_44839
        Constellation/AllUsers
        Satellite/tle-44839_44839
    END Instance
    Instance Satellite/tle-44879_44879
        Constellation/AllUsers
        Satellite/tle-44879_44879
    END Instance
    Instance Satellite/tle-44880_44880
        Constellation/AllUsers
        Satellite/tle-44880_44880
    END Instance
    Instance Satellite/tle-45624_45624
        Constellation/AllUsers
        Satellite/tle-45624_45624
    END Instance
    Instance Satellite/tle-45796_45796
        Constellation/AllUsers
        Satellite/tle-45796_45796
    END Instance
    Instance Satellite/tle-46266_46266
        Constellation/AllUsers
        Satellite/tle-46266_46266
    END Instance
    Instance Satellite/tle-46277_46277
        Constellation/AllUsers
        Satellite/tle-46277_46277
    END Instance
    Instance Satellite/tle-46278_46278
        Constellation/AllUsers
        Satellite/tle-46278_46278
    END Instance
    Instance Satellite/tle-46279_46279
        Constellation/AllUsers
        Satellite/tle-46279_46279
    END Instance
    Instance Satellite/tle-46292_46292
        Constellation/AllUsers
        Satellite/tle-46292_46292
    END Instance
    Instance Satellite/tle-46293_46293
        Constellation/AllUsers
        Satellite/tle-46293_46293
    END Instance
    Instance Satellite/tle-46312_46312
        Constellation/AllUsers
        Satellite/tle-46312_46312
    END Instance
    Instance Satellite/tle-46320_46320
        Constellation/AllUsers
        Satellite/tle-46320_46320
    END Instance
    Instance Satellite/tle-46489_46489
        Constellation/AllUsers
        Satellite/tle-46489_46489
    END Instance
    Instance Satellite/tle-46496_46496
        Constellation/AllUsers
        Satellite/tle-46496_46496
    END Instance
    Instance Satellite/tle-46497_46497
        Constellation/AllUsers
        Satellite/tle-46497_46497
    END Instance
    Instance Satellite/tle-46931_46931
        Constellation/AllUsers
        Satellite/tle-46931_46931
    END Instance
    Instance Satellite/tle-47300_47300
        Constellation/AllUsers
        Satellite/tle-47300_47300
    END Instance
    Instance Satellite/tle-47441_47441
        Constellation/AllUsers
        Satellite/tle-47441_47441
    END Instance
    Instance Satellite/tle-47485_47485
        Constellation/AllUsers
        Satellite/tle-47485_47485
    END Instance
    Instance Satellite/tle-47502_47502
        Constellation/AllUsers
        Satellite/tle-47502_47502
    END Instance
    Instance Satellite/tle-47505_47505
        Constellation/AllUsers
        Satellite/tle-47505_47505
    END Instance
    Instance Satellite/tle-47506_47506
        Constellation/AllUsers
        Satellite/tle-47506_47506
    END Instance
    Instance Satellite/tle-47507_47507
        Constellation/AllUsers
        Satellite/tle-47507_47507
    END Instance
    Instance Satellite/tle-47508_47508
        Constellation/AllUsers
        Satellite/tle-47508_47508
    END Instance
    Instance Satellite/tle-47509_47509
        Constellation/AllUsers
        Satellite/tle-47509_47509
    END Instance
    Instance Satellite/tle-47510_47510
        Constellation/AllUsers
        Satellite/tle-47510_47510
    END Instance
    Instance Satellite/tle-47933_47933
        Constellation/AllUsers
        Satellite/tle-47933_47933
    END Instance
    Instance Satellite/tle-47934_47934
        Constellation/AllUsers
        Satellite/tle-47934_47934
    END Instance
    Instance Satellite/tle-47935_47935
        Constellation/AllUsers
        Satellite/tle-47935_47935
    END Instance
    Instance Satellite/tle-47936_47936
        Constellation/AllUsers
        Satellite/tle-47936_47936
    END Instance
    Instance Satellite/tle-47940_47940
        Constellation/AllUsers
        Satellite/tle-47940_47940
    END Instance
    Instance Satellite/tle-47953_47953
        Constellation/AllUsers
        Satellite/tle-47953_47953
    END Instance
    Instance Satellite/tle-48248_48248
        Constellation/AllUsers
        Satellite/tle-48248_48248
    END Instance
    Instance Satellite/tle-48249_48249
        Constellation/AllUsers
        Satellite/tle-48249_48249
    END Instance
    Instance Satellite/tle-48254_48254
        Constellation/AllUsers
        Satellite/tle-48254_48254
    END Instance
    Instance Satellite/tle-48255_48255
        Constellation/AllUsers
        Satellite/tle-48255_48255
    END Instance
    Instance Satellite/tle-48272_48272
        Constellation/AllUsers
        Satellite/tle-48272_48272
    END Instance
    Instance Satellite/tle-48901_48901
        Constellation/AllUsers
        Satellite/tle-48901_48901
    END Instance
    Instance Satellite/tle-48906_48906
        Constellation/AllUsers
        Satellite/tle-48906_48906
    END Instance
    Instance Satellite/tle-48910_48910
        Constellation/AllUsers
        Satellite/tle-48910_48910
    END Instance
    Instance Satellite/tle-48914_48914
        Constellation/AllUsers
        Satellite/tle-48914_48914
    END Instance
    Instance Satellite/tle-48916_48916
        Constellation/AllUsers
        Satellite/tle-48916_48916
    END Instance
    Instance Satellite/tle-48917_48917
        Constellation/AllUsers
        Satellite/tle-48917_48917
    END Instance
    Instance Satellite/tle-48918_48918
        Constellation/AllUsers
        Satellite/tle-48918_48918
    END Instance
    Instance Satellite/tle-48922_48922
        Constellation/AllUsers
        Satellite/tle-48922_48922
    END Instance
    Instance Satellite/tle-48926_48926
        Constellation/AllUsers
        Satellite/tle-48926_48926
    END Instance
    Instance Satellite/tle-48928_48928
        Constellation/AllUsers
        Satellite/tle-48928_48928
    END Instance
    Instance Satellite/tle-48930_48930
        Constellation/AllUsers
        Satellite/tle-48930_48930
    END Instance
    Instance Satellite/tle-48931_48931
        Constellation/AllUsers
        Satellite/tle-48931_48931
    END Instance
    Instance Satellite/tle-48942_48942
        Constellation/AllUsers
        Satellite/tle-48942_48942
    END Instance
    Instance Satellite/tle-48948_48948
        Constellation/AllUsers
        Satellite/tle-48948_48948
    END Instance
    Instance Satellite/tle-48950_48950
        Constellation/AllUsers
        Satellite/tle-48950_48950
    END Instance
    Instance Satellite/tle-48953_48953
        Constellation/AllUsers
        Satellite/tle-48953_48953
    END Instance
    Instance Satellite/tle-48957_48957
        Constellation/AllUsers
        Satellite/tle-48957_48957
    END Instance
    Instance Satellite/tle-48962_48962
        Constellation/AllUsers
        Satellite/tle-48962_48962
    END Instance
    Instance Satellite/tle-48963_48963
        Constellation/AllUsers
        Satellite/tle-48963_48963
    END Instance
    Instance Satellite/tle-48965_48965
        Constellation/AllUsers
        Satellite/tle-48965_48965
    END Instance
    Instance Satellite/tle-49007_49007
        Constellation/AllUsers
        Satellite/tle-49007_49007
    END Instance
    Instance Satellite/tle-49066_49066
        Constellation/AllUsers
        Satellite/tle-49066_49066
    END Instance
END References

END Scenario
