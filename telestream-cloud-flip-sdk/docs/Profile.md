
# Profile

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**advancedFpsConversion** | [**AdvancedFpsConversionEnum**](#AdvancedFpsConversionEnum) | todo |  [optional]
**aspectMode** | **String** | Specifies an aspect mode for output videos. The following options are available:   - preserve   - constrain   - letterbox   - pad   - fill (crop)   - stretch   - center Default is \&quot;letterbox\&quot;. |  [optional]
**aspectRatio** | **String** | A display aspect ratio. By default it is not set. |  [optional]
**audioBitrate** | **Integer** | audio bitrate (in bits/s) |  [optional]
**audioChannels** | **Integer** | A number of audio channels. By default it is not set. |  [optional]
**audioChannelsLayout** | [**AudioChannelsLayoutEnum**](#AudioChannelsLayoutEnum) | A channel layout specifies the spatial disposition of the channels in a multi-channel audio stream. |  [optional]
**audioChannelsPerTrack** | **Integer** | A number of audio channels per track. |  [optional]
**audioCodec** | **String** | Audio codec that will be used by the profile. Available codecs are: &#x60;libmp3lame&#x60;, &#x60;libvorbis&#x60;, &#x60;libfdk_aac&#x60;, &#x60;dib_ac3, &#x60;pcm_s16le&#x60;, &#x60;mp2&#x60;, &#x60;ac3&#x60;, &#x60;eac3&#x60;. |  [optional]
**audioFormat** | [**AudioFormatEnum**](#AudioFormatEnum) | Specifies an audio container. |  [optional]
**audioMap** | **String** |  |  [optional]
**audioPid** | **String** | Packet identifier used by MPEG formats. |  [optional]
**audioProfile** | **String** | Specifies an audio profile. |  [optional]
**audioSampleRate** | **String** | The number of samples of audio carried per second. |  [optional]
**audioStreamId** | **Integer** |  |  [optional]
**audioStreams** | **Integer** | A number of audio streams. |  [optional]
**avcintraClass** | [**AvcintraClassEnum**](#AvcintraClassEnum) | A class of the AVC-Intra video coding. |  [optional]
**bufferSize** | **String** | Determines the size of the PulseAudio buffer. by default it is not set. |  [optional]
**bufferSizeInPackets** | **String** | todo |  [optional]
**bumpers** | **Object** |  |  [optional]
**byteRangeRequests** | **Boolean** |  |  [optional]
**clipEnd** | **String** | Clip ends at a specific time (timecode). |  [optional]
**pixelFormat** | **String** |  |  [optional]
**clipLength** | **String** | A clip’s duration. |  [optional]
**clipOffset** | **String** | Clip starts at a specific offset. |  [optional]
**closedCaptions** | [**ClosedCaptionsEnum**](#ClosedCaptionsEnum) | One of add (adds captions as a separate streams) or burn (burns captions on video stream using the first subtitle file). By default it is not set. |  [optional]
**colorMetadata** | **Boolean** |  |  [optional]
**createdAt** | **String** | A date and time when the Profile has been created. |  [optional]
**cropInputBottom** | **String** | Distance (in pixels) from the bottom edge of the screen from which you want your crop to be done. |  [optional]
**cropInputHeight** | **String** | Width of the cropped image in pixels. |  [optional]
**cropInputLeft** | **String** | Distance (in pixels) from the left edge of the screen from which you want your crop to be done. |  [optional]
**cropInputRight** | **String** | Distance (in pixels) from the right edge of the screen from which you want your crop to be done. |  [optional]
**cropInputTop** | **String** | Distance (in pixels) from the top edge of the screen from which you want your crop to be done. |  [optional]
**cropInputWidth** | **String** | Height of the cropped image in pixels. |  [optional]
**dashProfile** | **String** |  |  [optional]
**deinterlace** | **String** | One of &#x60;keep_fps&#x60; or &#x60;double_fps&#x60;. By default it is not set. |  [optional]
**deinterlaceFrames** | **String** |  |  [optional]
**description** | **String** | Description of the profile. |  [optional]
**dnxhdType** | [**DnxhdTypeEnum**](#DnxhdTypeEnum) |  |  [optional]
**encryption** | **Boolean** |  |  [optional]
**extname** | **String** | File extension. |  [optional]
**fps** | **String** | Null value copy the original fps. By default it is not set. |  [optional]
**frameCount** | **String** | Evenly spaced number of generated screenshots. By default it is not set. |  [optional]
**frameInterval** | **String** | Thumbnail interval (Frames or seconds). |  [optional]
**frameOffsets** | **String** | Array of offsets (Frames or seconds). |  [optional]
**h264Level** | [**H264LevelEnum**](#H264LevelEnum) | A specified set of constraints that indicate a degree of required decoder performance for a profile. |  [optional]
**h264Profile** | [**H264ProfileEnum**](#H264ProfileEnum) | Profiles represent a sub-set of the encoding techniques available in H.264. |  [optional]
**h264Tune** | [**H264TuneEnum**](#H264TuneEnum) | Specifies a h264 tuning option. |  [optional]
**height** | **String** | Height in pixels. |  [optional]
**id** | **String** |  |  [optional]
**imxType** | **String** |  |  [optional]
**inputs** | **Object** |  |  [optional]
**interlace** | **String** |  |  [optional]
**keyframeInterval** | **String** | Adds a key frame every N frames. Default is 250, adds a key frame every 250 frames. |  [optional]
**keyframeRate** | **String** | todo |  [optional]
**lang** | **String** |  |  [optional]
**maxRate** | **String** | A max bitrate tolerance (in bits/s). By default this is not set. |  [optional]
**mergeAudioStreams** | **String** |  |  [optional]
**muteAudioTracks** | **Boolean** | Remove audio from input video file. By default it is set to &#x60;false&#x60;. |  [optional]
**name** | **String** | A unique machine-readable name that will identify the profile. Helpful later on for filtering encodings by profile. |  [optional]
**outputs** | **Object** |  |  [optional]
**outputsPathFormat** | **String** | Specify the directory where the output files should be stored. By default it is not set. More information about this [here](https://cloud.telestream.net/docs#path-format---know-how). |  [optional]
**playlistType** | [**PlaylistTypeEnum**](#PlaylistTypeEnum) |  |  [optional]
**pmtPid** | **String** |  |  [optional]
**presetName** | **String** | a name of a preset that a profile will use. |  [optional]
**proresFormat** | **String** |  |  [optional]
**segmentTime** | **Integer** | Minimum value is 2, maximum is 60. |  [optional]
**stack** | **String** |  |  [optional]
**startingTimecode** | **String** |  |  [optional]
**telestreamBlockSize** | [**TelestreamBlockSizeEnum**](#TelestreamBlockSizeEnum) |  |  [optional]
**telestreamBlurScaler** | [**BigDecimal**](BigDecimal.md) | Minimum value is 0, maximum is 4. |  [optional]
**telestreamCostScaler** | [**BigDecimal**](BigDecimal.md) | Minimum value is 0, maximum is 4. |  [optional]
**telestreamSearchLengthScaler** | **Integer** | Minimum value is 0, maximum is 2. |  [optional]
**telestreamSubpelMode** | **Boolean** |  |  [optional]
**timeCode** | **String** | If set, timestamps will be added to your videos. By default this is not set. |  [optional]
**title** | **String** | Human-readable name. |  [optional]
**trailers** | **Object** |  |  [optional]
**transportRate** | **String** |  |  [optional]
**tsPids** | **String** |  |  [optional]
**updatedAt** | **String** |  |  [optional]
**upscale** | **Boolean** | Upscale the video resolution to match your profile. Default is &#x60;true&#x60;. |  [optional]
**useEditlist** | **Boolean** |  |  [optional]
**variants** | **String** | Pattern utilised to match HLS.Variant presets by name. Default is hls.*. |  [optional]
**videoBitrate** | **Integer** |  |  [optional]
**videoPid** | **String** |  |  [optional]
**watermarkBottom** | **String** | Distance from the bottom of the video frame in pixels or percentage of video frame height. Works like CSS. Default is &#x60;0&#x60;. |  [optional]
**watermarkBumpers** | **Boolean** |  |  [optional]
**watermarkHeight** | **String** | Height of the watermark image in pixels or percentage of video frame height. Default is no resizing |  [optional]
**watermarkLeft** | **String** | Distance from the left of the video frame in pixels or percentage of video frame width. Works like CSS. Default is &#x60;0&#x60;. |  [optional]
**watermarkRight** | **String** | Distance from the right of the video frame in pixels or percentage of video frame width. Works like CSS. Default is &#x60;0&#x60;. |  [optional]
**watermarkTop** | **String** | Distance from the top of the video frame in pixels or percentage of video frame height. Works like CSS. Default is &#x60;0&#x60;. |  [optional]
**watermarkTrailers** | **Boolean** |  |  [optional]
**watermarkUrl** | **String** | Url of a watermark image. |  [optional]
**watermarkWidth** | **String** | Width of the watermark image in pixels or percentage of video frame width. Default is &#x60;no resizing&#x60;. |  [optional]
**width** | **String** | Width in pixels. |  [optional]
**x264Options** | **String** |  |  [optional]
**x265Options** | **String** |  |  [optional]
**xdcamFormat** | **String** |  |  [optional]
**tachyonAllowRemovePulldown** | **Boolean** | Enable more sensitive pulldown removal algorithm. |  [optional]
**tachyonEnablePostPulldownFilter** | **Boolean** | If the images you are converting are composited 29.976, but the pulldown pattern was not adhered to when performing the composite, this setting is required to remove combing artifacts. It will also remove combing artifacts related to very poor 3:2 cadence. |  [optional]
**tachyonMediaHintIsCartoon** | **Boolean** |  |  [optional]
**tachyonMediaHintHasChromaNoise** | **Boolean** | Remove chroma noise during the analysis of a video. |  [optional]
**tachyonMoreSensitiveRemovePulldown** | **Boolean** | When pulldown is not achieved due to extremely broken cadence, or other factors like highly mixed content or if chroma noise masks motion, the pulldown engine may fall back to de-interlacing rather than removing telecine. If that&#39;s a case, a more sensitive pulldown pattern can be used. This algorithm favors inverse telecine and with lower thresholds for triggering pulldown identification, will maximize the number of progressive frames created from the video. |  [optional]
**tachyonAllowAddStandardPd** | **Boolean** |  |  [optional]
**tachyonAllowAdd22pd** | **Boolean** | Allows 2:2 (PSF) Insertion. Creates a new series of frames which are based on duplicating the field an interlacing it into top/bottom field. Maintains a film-look. |  [optional]
**tachyonAllowAdd44pd** | **Boolean** | Allows 4:4 Insertion. Repeats each progressive frame twice on output (motion rate is halved). This setting is used when you want to convert to high progressive frame rates (i.e. 50p/59.94p/60p) but want to preserve film qualities (low motion rate, such as 24p). |  [optional]
**tachyonAllowAdd46pd** | **Boolean** | 2:3 Insertion. inserts a standard 2:3 telecine pattern to 23.976p video stream to achieve a 29.97i frame rate |  [optional]
**tachyonAllowAddEuroPd** | **Boolean** | Allows Euro Insertion. For field based interpolation rather than pixel-based. This is designed for interlaced or progressive integer frame rate conversions that are being converted to interlaced outputs. This method is valid for 24p to 50i conversions only. |  [optional]
**tachyonAllowAddAdaptivePd** | **Boolean** | Allows Adaptive Insertion. For field-based interpolation rather than using pixel-based interpolation. This algorithm is designed for both integer and non-integer frame rate conversion targets - as long as one of them is a non-integer rate (23.976, 29.97, 59.94, etc). This creates NTSC-PAL conversions clean of motion artifacts at the expense of potential slight stutter. Stutter is most noticeable with material that has smooth and uniform motion. |  [optional]
**tachyonMotionAmount** | [**TachyonMotionAmountEnum**](#TachyonMotionAmountEnum) | This setting determines how much Tachyon will trust motion vectors in the creation of new images |  [optional]
**tachyonFallbackSize** | [**TachyonFallbackSizeEnum**](#TachyonFallbackSizeEnum) | This option specifies the transition region size between fallback areas and motion compensated areas. A larger fallback size allows more blending (feathering) to occur between the regions. |  [optional]
**tachyonMblockSize** | [**TachyonMblockSizeEnum**](#TachyonMblockSizeEnum) | This option specifies the size of a motion block. |  [optional]
**tachyonCutDetectionSensitivity** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**eac3EvolutionEnable** | **Boolean** | Enables the trusted metadata framework. |  [optional]
**eac3BitstreamMode** | [**Eac3BitstreamModeEnum**](#Eac3BitstreamModeEnum) | Selects the type of audio service. **For 1/0 Voiceover will be used when Voiceover/Karaoke is selected. For 2/0 and above Karaoke will be used. |  [optional]
**eac3NinetyDegreePhaseShift** | **Boolean** | Applies a 90-degree phase shift to the surround channels; necessary if the output file is being decoded by a Dolby Surround Pro Logic or Pro Logic II decoder. |  [optional]
**eac3ThreeDecibelAttenuation** | **Boolean** | Attenuates the surround channels by 3 dB before encoding. |  [optional]
**eac3EnableLfeLowPassFilter** | **Boolean** | Applies a 120 Hz eighth order lowpass filter to the LFE input prior to encoding. |  [optional]
**eac3AnalogToDigitalConverterType** | [**Eac3AnalogToDigitalConverterTypeEnum**](#Eac3AnalogToDigitalConverterTypeEnum) | Allows audio that has passed through an A/D conversion stage to be marked as such. |  [optional]
**eac3StereoDownmixPreference** | [**Eac3StereoDownmixPreferenceEnum**](#Eac3StereoDownmixPreferenceEnum) |  |  [optional]
**eac3LtRtCenterMixLevel** | [**Eac3LtRtCenterMixLevelEnum**](#Eac3LtRtCenterMixLevelEnum) | Indicates the level shift applied to the center channel when adding to the left and right outputs during a downmix to a Lt/Rt output. |  [optional]
**eac3LtRtSurroundMixLevel** | [**Eac3LtRtSurroundMixLevelEnum**](#Eac3LtRtSurroundMixLevelEnum) | Indicates the level shift applied to the surround channel when adding to the left and right outputs during a downmix to a Lt/Rt output. |  [optional]
**eac3LoRoCenterMixLevel** | [**Eac3LoRoCenterMixLevelEnum**](#Eac3LoRoCenterMixLevelEnum) | Indicates the level shift applied to the center channel when adding to the left and right outputs during a downmix to a Lo/Ro output. |  [optional]
**eac3LoRoSurroundMixLevel** | [**Eac3LoRoSurroundMixLevelEnum**](#Eac3LoRoSurroundMixLevelEnum) | Indicates the level shift applied to the surround channel when adding to the left and right outputs during a downmix to a Lo/Ro output. |  [optional]
**eac3SurroundExMode** | [**Eac3SurroundExModeEnum**](#Eac3SurroundExModeEnum) | Indicates whether the audio stream was encoded using Dolby EX. |  [optional]
**eac3DrcLineModeProfile** | [**Eac3DrcLineModeProfileEnum**](#Eac3DrcLineModeProfileEnum) | Dynamic Range Control for Line Mode. |  [optional]
**eac3DrcRfModeProfile** | [**Eac3DrcRfModeProfileEnum**](#Eac3DrcRfModeProfileEnum) | Dynamic Range Control for RF Mode. |  [optional]
**eac3DialogNormalization** | **Integer** | Represents the volume level of dialog in the audio stream which can be used by a Dolby Digital decoder. This aids the decoder in matching volume between program sources. Minimum value is 1, maximum is 31. |  [optional]
**eac3RoomType** | [**Eac3RoomTypeEnum**](#Eac3RoomTypeEnum) |  |  [optional]
**eac3MixingLevel** | **Integer** | Minimum value is 80, maximum is 111. |  [optional]
**eac3CopyrightProtected** | **Boolean** | Indicates whether the encoded bitstream is copyright protected. |  [optional]
**eac3OriginalBitstream** | **Boolean** | Indicates whether the encoded bitstream is the master version, or a copy. |  [optional]


<a name="AdvancedFpsConversionEnum"></a>
## Enum: AdvancedFpsConversionEnum
Name | Value
---- | -----
TELESTREAM | &quot;telestream&quot;
TACHYON | &quot;tachyon&quot;


<a name="AudioChannelsLayoutEnum"></a>
## Enum: AudioChannelsLayoutEnum
Name | Value
---- | -----
_1_0 | &quot;1.0&quot;
_2_0 | &quot;2.0&quot;
_2_1 | &quot;2.1&quot;
_3_0 | &quot;3.0&quot;
_3_0_BACK_ | &quot;3.0(back)&quot;
_3_1 | &quot;3.1&quot;
_4_0 | &quot;4.0&quot;
_4_1 | &quot;4.1&quot;
QUAD | &quot;quad&quot;
_5_0 | &quot;5.0&quot;
_5_0_SIDE_ | &quot;5.0(side)&quot;
_5_1_SIDE_ | &quot;5.1(side)&quot;
_6_0 | &quot;6.0&quot;
_6_1 | &quot;6.1&quot;
_7_0 | &quot;7.0&quot;
_7_1 | &quot;7.1&quot;
MONO | &quot;mono&quot;
STEREO | &quot;stereo&quot;


<a name="AudioFormatEnum"></a>
## Enum: AudioFormatEnum
Name | Value
---- | -----
S24LE | &quot;pcm_s24le&quot;
S16LE | &quot;pcm_s16le&quot;


<a name="AvcintraClassEnum"></a>
## Enum: AvcintraClassEnum
Name | Value
---- | -----
_50 | &quot;50&quot;
_100 | &quot;100&quot;


<a name="ClosedCaptionsEnum"></a>
## Enum: ClosedCaptionsEnum
Name | Value
---- | -----
ADD | &quot;add&quot;
BURN | &quot;burn&quot;


<a name="DnxhdTypeEnum"></a>
## Enum: DnxhdTypeEnum
Name | Value
---- | -----
_36 | &quot;36&quot;
_45 | &quot;45&quot;
_60 | &quot;60&quot;
_75 | &quot;75&quot;
_90 | &quot;90&quot;
_90X | &quot;90x&quot;
_110 | &quot;110&quot;
_115 | &quot;115&quot;
_120 | &quot;120&quot;
_145 | &quot;145&quot;
_175X | &quot;175x&quot;
_175 | &quot;175&quot;
_185X | &quot;185x&quot;
_185 | &quot;185&quot;
_220X | &quot;220x&quot;
_220 | &quot;220&quot;


<a name="H264LevelEnum"></a>
## Enum: H264LevelEnum
Name | Value
---- | -----
_1_0 | &quot;1.0&quot;
_1B | &quot;1b&quot;
_1_1 | &quot;1.1&quot;
_1_2 | &quot;1.2&quot;
_1_3 | &quot;1.3&quot;
_2_0 | &quot;2.0&quot;
_2_1 | &quot;2.1&quot;
_2_2 | &quot;2.2&quot;
_3_0 | &quot;3.0&quot;
_3_1 | &quot;3.1&quot;
_3_2 | &quot;3.2&quot;
_4_0 | &quot;4.0&quot;
_4_1 | &quot;4.1&quot;
_4_2 | &quot;4.2&quot;
_5_0 | &quot;5.0&quot;
_5_1 | &quot;5.1&quot;


<a name="H264ProfileEnum"></a>
## Enum: H264ProfileEnum
Name | Value
---- | -----
BASELINE | &quot;baseline&quot;
MAIN | &quot;main&quot;
HIGH | &quot;high&quot;
HIGH10 | &quot;high10&quot;
HIGH422 | &quot;high422&quot;
HIGH444 | &quot;high444&quot;


<a name="H264TuneEnum"></a>
## Enum: H264TuneEnum
Name | Value
---- | -----
FILM | &quot;film&quot;
ANIMATION | &quot;animation&quot;
GRAIN | &quot;grain&quot;
PSNR | &quot;psnr&quot;
SSIM | &quot;ssim&quot;
FASTDECODE | &quot;fastdecode&quot;
ZEROLATENCY | &quot;zerolatency&quot;


<a name="PlaylistTypeEnum"></a>
## Enum: PlaylistTypeEnum
Name | Value
---- | -----
IFRAME | &quot;iframe&quot;
IFRAME_ONLY | &quot;iframe-only&quot;


<a name="TelestreamBlockSizeEnum"></a>
## Enum: TelestreamBlockSizeEnum
Name | Value
---- | -----
_16X16 | &quot;16x16&quot;
_24X24 | &quot;24x24&quot;
_32X32 | &quot;32x32&quot;


<a name="TachyonMotionAmountEnum"></a>
## Enum: TachyonMotionAmountEnum
Name | Value
---- | -----
XLOW | &quot;xlow&quot;
LOW | &quot;low&quot;
MEDIUM | &quot;medium&quot;
HIGH | &quot;high&quot;
XHIGH | &quot;xhigh&quot;
AUTO | &quot;auto&quot;


<a name="TachyonFallbackSizeEnum"></a>
## Enum: TachyonFallbackSizeEnum
Name | Value
---- | -----
SMALL | &quot;small&quot;
MEDIUM | &quot;medium&quot;
LARGE | &quot;large&quot;
XLARGE | &quot;xlarge&quot;
AUTO | &quot;auto&quot;


<a name="TachyonMblockSizeEnum"></a>
## Enum: TachyonMblockSizeEnum
Name | Value
---- | -----
MB16 | &quot;mb16&quot;
MB32 | &quot;mb32&quot;
MB64 | &quot;mb64&quot;
MB128 | &quot;mb128&quot;
MB256 | &quot;mb256&quot;
AUTO | &quot;auto&quot;


<a name="Eac3BitstreamModeEnum"></a>
## Enum: Eac3BitstreamModeEnum
Name | Value
---- | -----
M0 | &quot;m0&quot;
M1 | &quot;m1&quot;
M2 | &quot;m2&quot;
M3 | &quot;m3&quot;
M4 | &quot;m4&quot;
M5 | &quot;m5&quot;
M6 | &quot;m6&quot;
M7 | &quot;m7&quot;


<a name="Eac3AnalogToDigitalConverterTypeEnum"></a>
## Enum: Eac3AnalogToDigitalConverterTypeEnum
Name | Value
---- | -----
STANDARD | &quot;standard&quot;
HDCD | &quot;hdcd&quot;


<a name="Eac3StereoDownmixPreferenceEnum"></a>
## Enum: Eac3StereoDownmixPreferenceEnum
Name | Value
---- | -----
M0 | &quot;m0&quot;
M1 | &quot;m1&quot;
M2 | &quot;m2&quot;
M3 | &quot;m3&quot;


<a name="Eac3LtRtCenterMixLevelEnum"></a>
## Enum: Eac3LtRtCenterMixLevelEnum
Name | Value
---- | -----
C0 | &quot;c0&quot;
C1 | &quot;c1&quot;
C2 | &quot;c2&quot;
C3 | &quot;c3&quot;
C4 | &quot;c4&quot;
C5 | &quot;c5&quot;
C6 | &quot;c6&quot;
C7 | &quot;c7&quot;


<a name="Eac3LtRtSurroundMixLevelEnum"></a>
## Enum: Eac3LtRtSurroundMixLevelEnum
Name | Value
---- | -----
C3 | &quot;c3&quot;
C4 | &quot;c4&quot;
C5 | &quot;c5&quot;
C6 | &quot;c6&quot;
C7 | &quot;c7&quot;


<a name="Eac3LoRoCenterMixLevelEnum"></a>
## Enum: Eac3LoRoCenterMixLevelEnum
Name | Value
---- | -----
C0 | &quot;c0&quot;
C1 | &quot;c1&quot;
C2 | &quot;c2&quot;
C3 | &quot;c3&quot;
C4 | &quot;c4&quot;
C5 | &quot;c5&quot;
C6 | &quot;c6&quot;
C7 | &quot;c7&quot;


<a name="Eac3LoRoSurroundMixLevelEnum"></a>
## Enum: Eac3LoRoSurroundMixLevelEnum
Name | Value
---- | -----
C3 | &quot;c3&quot;
C4 | &quot;c4&quot;
C5 | &quot;c5&quot;
C6 | &quot;c6&quot;
C7 | &quot;c7&quot;


<a name="Eac3SurroundExModeEnum"></a>
## Enum: Eac3SurroundExModeEnum
Name | Value
---- | -----
M0 | &quot;m0&quot;
M1 | &quot;m1&quot;
M2 | &quot;m2&quot;


<a name="Eac3DrcLineModeProfileEnum"></a>
## Enum: Eac3DrcLineModeProfileEnum
Name | Value
---- | -----
P0 | &quot;p0&quot;
P1 | &quot;p1&quot;
P2 | &quot;p2&quot;
P3 | &quot;p3&quot;
P4 | &quot;p4&quot;
P5 | &quot;p5&quot;


<a name="Eac3DrcRfModeProfileEnum"></a>
## Enum: Eac3DrcRfModeProfileEnum
Name | Value
---- | -----
P0 | &quot;p0&quot;
P1 | &quot;p1&quot;
P2 | &quot;p2&quot;
P3 | &quot;p3&quot;
P4 | &quot;p4&quot;
P5 | &quot;p5&quot;


<a name="Eac3RoomTypeEnum"></a>
## Enum: Eac3RoomTypeEnum
Name | Value
---- | -----
M0 | &quot;m0&quot;
M1 | &quot;m1&quot;
M2 | &quot;m2&quot;



