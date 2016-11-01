/*
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.service.neomedia;

/**
 * Finds the {@code RTPEncoding} that corresponds to RTP packets.
 *
 * @author George Politis
 */
public interface RTPEncodingResolver
{
    /**
     * Finds the {@code RTPEncoding} that matches {@code ByteArrayBuffer} passed
     * in as a parameter.
     *
     * @param baf the {@code ByteArrayBuffer} of the {@code RTPEncoding}
     * to match.
     *
     * @return the {@code RTPEncoding} that matches the pkt passed in as
     * a parameter, or null if there is no matching {@code RTPEncoding}.
     */
    RTPEncoding resolveRTPEncoding(ByteArrayBuffer baf);
}