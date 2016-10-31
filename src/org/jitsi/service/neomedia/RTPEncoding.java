package org.jitsi.service.neomedia;

/**
 * Inspired by the ORTC RTCRtpEncodingParameters, the RTPEncoding provides
 * RTP encoding related information.
 *
 * @author George Politis
 */
public interface RTPEncoding
{
    /**
     *
     * @return
     */
    String getEncodingId();

    /**
     * Gets the primary SSRC for this layering/encoding.
     *
     * @return the primary SSRC for this layering/encoding.
     */
    long getPrimarySSRC();

    /**
     * Gets the RTX SSRC for this layering/encoding.
     *
     * @return the RTX SSRC for this layering/encoding.
     */
    long getRTXSSRC();

    /**
     *
     * @return
     */
    boolean isActive();

    /**
     *
     */
    double getFrameRateScale();

    /**
     *
     * @return
     */
    double getResolutionScale();

    /**
     *
     * @return
     */
    RTPEncoding[] getDependencyEncodings();
}
